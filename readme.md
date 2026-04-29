[![Maven Central](https://img.shields.io/maven-central/v/io.github.sudarshanmhasrup.splashify/splashify.svg?label=Maven%20Central)](https://search.maven.org/artifact/io.github.sudarshanmhasrup.splashify/splashify)
![Alpha](https://img.shields.io/badge/status-alpha-blue)
[![Kotlin](https://img.shields.io/badge/kotlin-2.3.21-blue.svg?logo=kotlin&logoColor=original)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose_Multiplatform-1.10.3-4285F4?style=flat&logo=jetpackcompose&logoColor=original)](https://www.jetbrains.com/compose-multiplatform/)

### About this project

Adding splash screens to desktop applications often involves repetitive code for window management and state
synchronization. Splashify provides a simple way to integrate splash screens into Compose Multiplatform desktop apps
with minimal configuration.

### Installation guide

Add the Splashify dependency to your project.

```kotlin
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation("io.github.sudarshanmhasrup.splashify:splashify:1.0.0-alpha1")
        }
    }
}
```

Quick copy:

```kotlin
implementation("io.github.sudarshanmhasrup.splashify:splashify:1.0.0-alpha1")
```

### Version catalog setup

Add the following to your `libs.versions.toml` file:

```toml
[versions]
splashify = "1.0.0-alpha1"

[libraries]
splashify = { module = "io.github.sudarshanmhasrup.splashify:splashify", version.ref = "splashify" }
```

Then use it in your `build.gradle.kts`:

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
* Professional look for desktop apps

### Supported platforms

| Platform | Target  |
|----------|---------|
| Desktop  | `jvm()` |

### Contributing

Contributions are welcome. Feel free to open an issue or submit a pull request on GitHub.

### Closing note

If you find Splashify helpful, consider giving it a star on GitHub. Happy coding.
