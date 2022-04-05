@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        val kotlin = "1.5.31"
        kotlin("multiplatform") version(kotlin)
        kotlin("native.cocoapods") version(kotlin)
        kotlin("plugin.serialization") version(kotlin)
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "nimbus-openrtb"

include("kotlin")
