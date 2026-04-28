package io.github.sudarshanmhasrup.splashify.internal

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf

internal class SplashScreenStateManager {
    var showSplashScreen by mutableStateOf(true)
    var loaderProgress by mutableStateOf(0f)

    init {
        
    }
}

internal val LocalSplashScreenStateManager = staticCompositionLocalOf<SplashScreenStateManager> {
    error("SplashScreenStateManager not provided")
}