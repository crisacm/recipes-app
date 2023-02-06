buildscript {
    // ext.compose_version = "1.2.0"

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://maven.google.com")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.4.1")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application").version("7.4.1").apply(false)
    id("com.android.library").version("7.4.1").apply(false)
    id("org.jetbrains.kotlin.android").version("1.7.0").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildscript)
}