package io.github.sudarshanmhasrup.splashify.internal

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
    var loaderProgress by mutableStateOf(0.0f)

    private val scope = CoroutineScope(context = Dispatchers.Main)

    init {
        scope.launch {
            repeat(times = 100) {
                loaderProgress += 0.01f
                delay(timeMillis = 10)
            }

            showSplashScreen = false
        }
    }
}

internal val LocalSplashScreenStateManager = staticCompositionLocalOf<SplashScreenStateManager> {
    error("SplashScreenStateManager not provided")
}