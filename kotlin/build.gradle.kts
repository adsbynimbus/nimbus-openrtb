import org.jetbrains.kotlin.gradle.dsl.*

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
        consumerProguardFile(layout.projectDirectory.file("src/androidMain/consumer-proguard-rules.pro"))
    }
    namespace = "com.adsbynimbus.openrtb"
}

kotlin {
    explicitApi()

    compilerOptions {
        apiVersion = KotlinVersion.KOTLIN_1_8
        languageVersion = KotlinVersion.KOTLIN_1_8
        optIn = listOf("kotlinx.serialization.ExperimentalSerializationApi")
    }

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

dokka {
    moduleName = "nimbus-openrtb"
    dokkaGeneratorIsolation = ClassLoaderIsolation()
    dokkaSourceSets {
        named("commonMain") {
            sourceLink {
                localDirectory = layout.projectDirectory.dir("src/$name/kotlin")
                remoteLineSuffix = "#L"
                remoteUrl(providers.gradleProperty("version")
                    .map { if (it == "development") "main" else "v$it" }
                    .map { "https://github.com/adsbynimbus/nimbus-openrtb/tree/$it/kotlin/src/$name/kotlin" }
                )
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
