import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

group = libs.versions.sample.group.get()
version = libs.versions.sample.version.get()

kotlin {
    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }
}

layout.buildDirectory.set(file("$rootDir/.build/sample"))