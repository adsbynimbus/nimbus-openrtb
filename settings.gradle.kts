@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

val androidGradleOverride = with(providers) {
    gradleProperty("android.studio.version").flatMap { gradleProperty("android.gradle") }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
    versionCatalogs.configureEach {
          if (androidGradleOverride.isPresent) version("android", androidGradleOverride.get())
    }
}

rootProject.name = "nimbus-openrtb"

include("kotlin")
