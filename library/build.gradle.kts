import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.maven.publish)
}

group = libs.versions.library.group.get()
version = libs.versions.library.version.get()

kotlin {
    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    sourceSets {
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.kotlinx.coroutines)
            implementation(libs.bundles.compose.multiplatform)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates(
        groupId = libs.versions.library.group.get(),
        artifactId = libs.versions.library.artifactId.get(),
        version = libs.versions.library.version.get()
    )

    pom {
        name.set("Splashify")
        description.set("A Kotlin Multiplatform library for effortless, customizable splash screens in Compose Multiplatform desktop apps.")
        inceptionYear.set("2026")
        url.set("https://github.com/sudarshanmhasrup/splashify")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                id.set("sudarshanmhasrup")
                name.set("Sudarshan Mhasrup")
                url.set("https://github.com/sudarshanmhasrup")
            }
        }
        scm {
            url.set("https://github.com/sudarshanmhasrup/splashify")
            connection.set("scm:git:https://github.com/sudarshanmhasrup/splashify.git")
            developerConnection.set("scm:git:ssh://git@github.com/sudarshanmhasrup/splashify.git")
        }
    }
}

layout.buildDirectory.set(file("$rootDir/.build/library"))