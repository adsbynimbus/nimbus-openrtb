allprojects {
    group = "com.adsbynimbus.openrtb"
    version = (System.getenv("TAG_NAME") ?: "development").split("/").last().let {
        if (it.startsWith("v")) it.substring(1) else it
    }
}

val clean by tasks.registering(Delete::class) {
    delete(buildDir)
}