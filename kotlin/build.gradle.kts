import groovy.util.Node
import groovy.util.NodeList
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("com.android.library") version ("7.0.0")
    kotlin("multiplatform") version ("1.5.30-M1")
    id("org.jetbrains.dokka") version ("1.5.0")
    `maven-publish`
}

android {
    buildToolsVersion = "31.0.0"
    compileSdk = 30
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
    android {
        publishLibraryVariants("release")
    }
    sourceSets {
        named("commonMain") {
            dependencies {
                compileOnly(kotlin("stdlib"))
            }
        }
        named("commonTest") {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(libs.spek.dsl.metadata)
            }
        }
        named("androidMain") {
            dependencies {
                implementation(libs.androidx.annotation)
            }
        }
        named("androidTest") {
            dependencies {
                implementation(kotlin("test-junit5"))
                implementation(libs.gson)
                implementation(libs.spek.dsl.jvm)

                runtimeOnly(kotlin("reflect"))
                runtimeOnly(libs.spek.runner)
            }
        }
    }
}

// Fixes an issue when creating the android sources jar
tasks.withType<AbstractCopyTask>().configureEach {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        matching { it.name in listOf("commonMain", "androidMain")}.configureEach {
            sourceLink {
                localDirectory.set(file("src/$name/kotlin"))
                remoteUrl.set(uri("https://github.com/timehop/nimbus-openrtb/kotlin/src/$name/kotlin").toURL())
                remoteLineSuffix.set("#L")
            }
        }
    }
}

val dokkaJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
    from(tasks.named("dokkaJavadoc"))
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
                artifact(dokkaJar)
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