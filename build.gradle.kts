plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
}

layout.buildDirectory.set(file("$rootDir/.build/project"))