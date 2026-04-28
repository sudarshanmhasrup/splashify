package com.sample.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.application
import io.github.sudarshanmhasrup.splashify.SplashifyApp

fun main() {
    application {
        SplashifyApp(splashScreen = { SplashScreen() }) {
            MainWindow(modifier = Modifier.fillMaxSize())
        }
    }
}