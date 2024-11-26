import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotest)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlin.serialization)
    `maven-publish`
}

val androidOnly: Boolean = providers.gradleProperty("android.injected.invoked.from.ide")
    .map { it.toBoolean() }.getOrElse(false)

android {
    compileSdk = 34
    defaultConfig {
        minSdk = 21
        consumerProguardFile("src/androidMain/consumer-proguard-rules.pro")
    }
    namespace = "com.adsbynimbus.openrtb"
}

kotlin {
    explicitApi()
    applyDefaultHierarchyTemplate()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        publishLibraryVariants("release")
    }

    /* Apple deployments in rough dependency order */
    if (!androidOnly) {
        iosArm64()
        iosSimulatorArm64()
    }
    sourceSets {
        configureEach {
            languageSettings {
                apiVersion = "1.6"
                languageVersion = "1.6"
                optIn("kotlinx.serialization.ExperimentalSerializationApi")
            }
        }
        commonMain.dependencies {
            implementation(libs.serialization.json)
        }
        commonTest.dependencies {
            implementation(libs.bundles.test.common)
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.bundles.test.android)
            }
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
