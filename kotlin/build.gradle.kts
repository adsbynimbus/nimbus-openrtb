import groovy.util.Node
import groovy.util.NodeList
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotest)
    alias(libs.plugins.cocoapods)
    alias(libs.plugins.dokka)
    alias(libs.plugins.serialization)
    `maven-publish`
}

group = "com.adsbynimbus.openrtb"
version = (System.getenv("TAG_NAME") ?: "0.0.1").split("/").last().let {
    if (it.startsWith("v")) it.substring(1) else it
}

android {
    buildToolsVersion = libs.versions.android.buildtools.get()
    compileSdk = 31
    defaultConfig {
        minSdk = 17
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

kotlin {
    explicitApi()

    android {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        publishLibraryVariants("release")
    }

    // Apple deployments in rough dependency order
    val xcf = XCFramework()

    cocoapods {
        summary = "Nimbus OpenRTB API Module"
        homepage = "https://www.github.com/timehop/nimbus-openrtb"
        license = "MIT"
        authors = "Ads By Nimbus"
        ios.deploymentTarget = "10.0"
        framework {
            baseName = "NimbusOpenRTB"
        }
    }

    iosX64 {
        binaries.framework {
            xcf.add(this)
        }
    }
    iosArm64 {
        binaries.framework {
            xcf.add(this)
        }
    }
    iosSimulatorArm64 {
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
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(libs.bundles.test.common)
            }
        }
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(libs.bundles.test.android)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<DokkaTask>().configureEach {
    moduleName.set("nimbus-openrtb")

    dokkaSourceSets {
        named("commonMain") {
            sourceLink {
                localDirectory.set(file("src/$name/kotlin"))
                remoteUrl.set(uri("https://github.com/timehop/nimbus-openrtb/kotlin/src/$name/kotlin").toURL())
                remoteLineSuffix.set("#L")
            }
        }
    }
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
