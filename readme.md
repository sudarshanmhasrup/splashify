[![Maven Central](https://img.shields.io/maven-central/v/io.github.sudarshanmhasrup.splashify/splashify.svg?label=Maven%20Central)](https://search.maven.org/artifact/io.github.sudarshanmhasrup.splashify/splashify)
![Alpha](https://img.shields.io/badge/status-alpha-blue)
[![Kotlin](https://img.shields.io/badge/kotlin-2.3.21-blue.svg?logo=kotlin&logoColor=original)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose_Multiplatform-1.10.3-4285F4?style=flat&logo=jetpackcompose&logoColor=original)](https://www.jetbrains.com/compose-multiplatform/)

### About this project

Adding splash screens to **Compose Multiplatform (CMP) desktop applications** often involves repetitive code for window
management and state synchronization. `Splashify` provides a simple way to integrate splash screens into CMP desktop
apps with minimal configuration.

### Demo

Check out Splashify in action:

<video src="https://github.com/user-attachments/assets/5b8a4638-323e-4651-a70d-19ec4d1f0d75" controls width="700"></video>

> A simple Compose Multiplatform desktop app showcasing splash screen integration using Splashify.

### Installation guide

To get started, add the `Splashify` dependency to your existing [Gradle](https://gradle.org/) project. To make
`Splashify` available in any module's classpath, copy and paste the following line into your module's `build.gradle.kts`
file under the `dependencies` block as shown below.

```kotlin
kotlin {
    sourceSets {
        jvmMain.dependencies {
            // Other dependencies will go here
            implementation("io.github.sudarshanmhasrup.splashify:splashify:1.0.0-alpha1")
        }
    }
}
```

To quickly copy the dependency, you can use the following command:

```kotlin
implementation("io.github.sudarshanmhasrup.splashify:splashify:1.0.0-alpha1")
```

If your project uses a version catalog for centralized dependency management, then add the following lines to your
`libs.versions.toml` file:

```
[versions]
# Other version declarations will go here
splashify = "1.0.0-alpha1"

[libraries]
# Other libraries declarations will go here
splashify = { module = "io.github.sudarshanmhasrup.splashify:splashify", version.ref = "splashify" }
```

Then you can refer to the dependency in your module's `build.gradle.kts` file like this:

```kotlin
kotlin {
    sourceSets {
        jvmMain.dependencies {
            // Other dependencies will go here
            implementation(libs.splashify)
        }
    }
}
```

To quickly copy the dependency, you can use the following command:

```kotlin
implementation(libs.splashify)
```

### Usage guide

Follow these examples to integrate Splashify into your application.

#### Wrap app using SplashifyApp

The `content` block must contain your main application `Window`.

```kotlin
fun main() = application {
    SplashifyApp(
        splashScreen = { SplashScreenContent() }
    ) {
        Window(onCloseRequest = ::exitApplication) {
            MainApp()
        }
    }
}
```

#### Example for SimpleSplashScreen

Use `SimpleSplashScreen` for basic splash screens. It provides access to the loading progress.

```kotlin
@Composable
fun SplashScreenContent() {
    val size = SplashScreenSize(width = 500.dp, height = 300.dp)
    val style = SplashScreenStyle(backgroundColor = Color.DarkGray)

    SimpleSplashScreen(size = size, style = style) { progress ->
        Text("Loading: ${(progress * 100).toInt()}%")
    }
}
```

#### Example for ProgressiveSplashScreen

Use `ProgressiveSplashScreen` to automatically include a progress indicator at the bottom.

```kotlin
@Composable
fun SplashScreenContent() {
    ProgressiveSplashScreen {
        Text("Splashify")
    }
}
```

### Features

* Simple API for quick integration
* Internal splash state handling
* Built-in support for progress tracking
* Customizable size, style, and indicators

### Supported platforms

| Platform | Target  |
|----------|---------|
| Desktop  | `jvm()` |

### Contributing

Contributions are welcome! Please feel free to open an issue or submit a pull request.

### Thank you! 🙌

Thank you so much for checking out the `Splashify` project. If you like my work on this project, feel free to give a
star to the repository. Happy coding!