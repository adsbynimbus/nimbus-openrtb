@file:OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage", "UNUSED_VARIABLE")

import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode.DISABLE
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotest)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlin.serialization)
    `maven-publish`
}

val androidOnly: Boolean = providers.gradleProperty("android.injected.invoked.from.ide")
    .map { it.toBoolean() }.getOrElse(false)

android {
    buildToolsVersion = libs.versions.android.buildtools.get()
    compileSdk = 33
    defaultConfig {
        minSdk = 19
        consumerProguardFile("src/androidMain/consumer-proguard-rules.pro")
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    namespace = "com.adsbynimbus.openrtb"
}

kotlin {
    explicitApi()
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        publishLibraryVariants("release")
    }

    /* Apple deployments in rough dependency order */
    if (!androidOnly) {
        cocoapods {
            summary = "Nimbus OpenRTB API Module"
            homepage = "https://www.github.com/timehop/nimbus-openrtb"
            license = "MIT"
            authors = "Ads By Nimbus"
            ios.deploymentTarget = "13.0"
            framework {
                baseName = "NimbusOpenRTB"
                isStatic = false
            }
        }

        iosArm64()
        iosSimulatorArm64()
        tvos()
    }
    sourceSets {
        configureEach {
            languageSettings {
                apiVersion = "1.6"
                languageVersion = "1.6"
                optIn("kotlinx.serialization.ExperimentalSerializationApi")
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
    notCompatibleWithConfigurationCache("Dokka does not support it yet")
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

publishing {
    repositories {
        maven {
            name = "aws"
            setUrl("s3://adsbynimbus-public/android/sdks")
            authentication {
                create<AwsImAuthentication>("awsIm")
            }
        }
        providers.environmentVariable("GITHUB_REPOSITORY").orNull?.let {
            maven {
                name = "github"
                url = uri("https://maven.pkg.github.com/$it")
                credentials(PasswordCredentials::class)
            }
        }
    }
}
