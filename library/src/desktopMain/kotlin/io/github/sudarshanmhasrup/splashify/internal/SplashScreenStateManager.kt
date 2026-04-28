package io.github.sudarshanmhasrup.splashify.internal

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class SplashScreenStateManager {
    var showSplashScreen by mutableStateOf(true)
    var loaderProgress by mutableStateOf(0f)

    private val scope = CoroutineScope(Dispatchers.Main)

    init {
        scope.launch {
            for (i in 0..10) {
                loaderProgress++
                delay(timeMillis = 250)
            }

            showSplashScreen = false
        }
    }
}

internal val LocalSplashScreenStateManager = staticCompositionLocalOf<SplashScreenStateManager> {
    error("SplashScreenStateManager not provided")
}