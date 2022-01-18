val clean by tasks.registering(Delete::class) {
    delete(buildDir)
}