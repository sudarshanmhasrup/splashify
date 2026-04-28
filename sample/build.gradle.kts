import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.sample.group.get()
version = libs.versions.sample.version.get()

kotlin {
    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    sourceSets {
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(projects.library)
        }
    }
}

compose.desktop {
    application {
        mainClass = libs.versions.sample.mainClass.get()
        nativeDistributions {
            targetFormats = setOf(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = libs.versions.sample.distributionPackageName.get()
            packageVersion = libs.versions.sample.distributionPackageVersion.get()
        }
    }
}

layout.buildDirectory.set(file("$rootDir/.build/sample"))