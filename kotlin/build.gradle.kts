import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotest)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlin.serialization)
    `maven-publish`
}

android {
    compileSdk = 36
    defaultConfig {
        minSdk = 21
        consumerProguardFile("src/androidMain/consumer-proguard-rules.pro")
    }
    namespace = "com.adsbynimbus.openrtb"
}

kotlin {
    explicitApi()

    androidTarget {
        compilations.configureEach {
            compileTaskProvider.configure {
                compilerOptions.jvmTarget = JvmTarget.JVM_1_8
            }
        }
        publishLibraryVariants("release")
    }

    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        configureEach {
            languageSettings {
                apiVersion = KotlinVersion.KOTLIN_1_8.version
                languageVersion = KotlinVersion.KOTLIN_1_8.version
                optIn("kotlinx.serialization.ExperimentalSerializationApi")
            }
        }
        commonMain.dependencies {
            implementation(libs.serialization.json)
        }
        commonTest.dependencies {
            implementation(libs.bundles.test.common)
        }
        androidUnitTest.dependencies {
            implementation(libs.bundles.test.android)
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<DokkaTask>().configureEach {
    moduleName = "nimbus-openrtb"

    dokkaSourceSets {
        named("commonMain") {
            sourceLink {
                localDirectory = layout.projectDirectory.file("src/$name/kotlin").asFile
                remoteUrl = uri("https://github.com/timehop/nimbus-openrtb/kotlin/src/$name/kotlin").toURL()
                remoteLineSuffix = "#L"
            }
        }
    }
}

publishing {
    repositories {
        maven("s3://adsbynimbus-public/android/sdks") {
            name = "aws"
            authentication {
                create<AwsImAuthentication>("awsIm")
            }
        }
        providers.environmentVariable("GITHUB_REPOSITORY").orNull?.let {
            maven("https://maven.pkg.github.com/$it") {
                name = "github"
                credentials(PasswordCredentials::class)
            }
        }
    }
}
