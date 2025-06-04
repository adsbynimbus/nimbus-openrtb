plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin)
}

android {
    //noinspection GradleDependency
    compileSdk = 34
    defaultConfig {
        minSdk = 21
        multiDexEnabled = true
    }
    namespace = "com.adsbynimbus.openrtb.android"

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    sourceSets.configureEach {
        if (name.contains("test", ignoreCase = true)) {
            java.srcDirs("../../kotlin/src/commonTest/kotlin")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(libs.openrtb)
    implementation(libs.serialization.json)
    implementation(libs.bundles.test)
    coreLibraryDesugaring(libs.desguaring)
}
