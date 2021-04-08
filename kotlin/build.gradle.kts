import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("com.android.library") version ("4.1.3")
    kotlin("multiplatform") version ("1.4.32")
    id("org.jetbrains.dokka") version ("1.4.30")
    `maven-publish`
}

val publish = System.getenv("GITHUB_WORKFLOW") != null
val spek = "2.0.15"

android {
    compileSdkVersion(30)
    defaultConfig {
        minSdkVersion(17)
        versionName(project.version.toString())

        consumerProguardFiles("consumer-proguard-rules.pro")
    }

    sourceSets {
        val main by getting {
            java.srcDirs("src/androidMain/kotlin")
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }
}

kotlin {
    android {
        if (publish) publishLibraryVariants("release") else publishAllLibraryVariants()
        compilations.all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
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
                implementation("org.spekframework.spek2:spek-dsl-metadata:$spek")
            }
        }
        named("androidMain") {
            dependencies {
                implementation("androidx.annotation:annotation:1.2.0")
            }
        }
        named("androidTest") {
            dependencies {
                implementation(kotlin("test-junit5"))
                implementation("com.google.code.gson:gson:2.8.6")
                implementation("org.spekframework.spek2:spek-dsl-jvm:$spek")

                runtimeOnly(kotlin("reflect"))
                runtimeOnly("org.spekframework.spek2:spek-runner-junit5:$spek")
            }
        }
    }
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        configureEach {
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

publishing {
    publications {
        afterEvaluate {
            named<MavenPublication>("androidRelease") {
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