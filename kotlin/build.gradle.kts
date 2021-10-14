import groovy.util.Node
import groovy.util.NodeList
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.cocoapods)
    alias(libs.plugins.dokka)
    alias(libs.plugins.serialization)
    `maven-publish`
}

android {
    buildToolsVersion = libs.versions.android.buildtools.get()
    compileSdk = 31
    defaultConfig {
        minSdk = 17

        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    sourceSets.getByName("main") {
        java.srcDirs("src/androidMain/kotlin")
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res")
    }
}

kotlin {
    explicitApi()

    // JVM based deployments in dependency order
    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform {
                includeEngines("spek2")
            }
        }
    }
    android {
        publishLibraryVariants("release")
    }

    // Apple deployments in rough dependency order
    val xcf = XCFramework()

    cocoapods {
        framework {
            isStatic = false
        }
    }

    ios {
        binaries.framework {
            xcf.add(this)
        }
    }
    tvos {
        binaries.framework {
            xcf.add(this)
        }
    }
    sourceSets {
        all {
            languageSettings {
                apiVersion = libs.versions.kotlin.api.get()
                optIn("kotlinx.serialization.ExperimentalSerializationApi")
                progressiveMode = true
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(libs.serialization.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.bundles.test.common)
                runtimeOnly(libs.spek.runtime)
            }
        }
        val jvmTest by getting {
            dependencies {
                runtimeOnly(libs.spek.junit5runner)
            }
        }
        val androidMain by getting
        val androidTest by getting
    }
}

// Fixes an issue when creating the android sources jar
tasks.withType<AbstractCopyTask>().configureEach {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.withType<DokkaTask>().configureEach {
    moduleName.set("nimbus-openrtb")

    dokkaSourceSets {
        matching { it.name in listOf("commonMain")}.configureEach {
            sourceLink {
                localDirectory.set(file("src/$name/kotlin"))
                remoteUrl.set(uri("https://github.com/timehop/nimbus-openrtb/kotlin/src/$name/kotlin").toURL())
                remoteLineSuffix.set("#L")
            }
        }
    }
}

configurations.create("sourcesElements") {
    isCanBeResolved = true
    attributes {
        attribute(DocsType.DOCS_TYPE_ATTRIBUTE, objects.named(DocsType.SOURCES))
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
        attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.DOCUMENTATION))
    }
    kotlin.sourceSets.getByName("commonMain").kotlin.srcDirs.forEach { outgoing.artifact(it) }
}

fun MavenPublication.replaceWith(other: MavenPublication) {
    lateinit var platformXml: XmlProvider
    other.pom.withXml { platformXml = this }

    pom.withXml {
        val root: Node = asNode()
        // Remove the original content and add the content from the platform POM:
        root.children().toList().forEach { root.remove(it as Node) }
        platformXml.asNode().children().forEach { root.append(it as Node) }

        // Adjust the self artifact ID, as it should match the root module's coordinates:
        ((root.get("artifactId") as NodeList)[0] as Node).setValue(artifactId)
        // Set packaging to POM to indicate that there's no artifact:
        ((root.get("packaging") as NodeList)[0] as Node).setValue("pom")

        // Remove the original platform dependencies and add a single dependency on the platform module:
        val dependencies = (root.get("dependencies") as NodeList)[0] as Node
        dependencies.children().toList().forEach { dependencies.remove(it as Node) }
        val singleDependency = dependencies.appendNode("dependency")
        singleDependency.appendNode("groupId", other.groupId)
        singleDependency.appendNode("artifactId", other.artifactId)
        singleDependency.appendNode("version", other.version)
        singleDependency.appendNode("scope", "compile")
    }

    tasks.matching { it.name == "generatePomFileForKotlinMultiplatformPublication"}.configureEach {
        dependsOn(tasks["generatePomFileFor${other.name.capitalize()}Publication"])
    }
}

publishing {
    afterEvaluate {
        publications {
            named<MavenPublication>("kotlinMultiplatform") {
                replaceWith(getByName<MavenPublication>("androidRelease"))
            }
        }
    }
    repositories {
        maven {
            name = "aws"
            setUrl("s3://adsbynimbus-public/android/sdks")
            credentials(AwsCredentials::class)
        }
        System.getenv("GITHUB_REPOSITORY")?.let {
            maven {
                name = "github"
                url = uri("https://maven.pkg.github.com/$it")
                credentials(PasswordCredentials::class)
            }
        }
    }
}