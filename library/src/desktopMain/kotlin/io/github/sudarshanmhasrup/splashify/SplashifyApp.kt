package io.github.sudarshanmhasrup.splashify

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import io.github.sudarshanmhasrup.splashify.internal.LocalSplashScreenStateManager
import io.github.sudarshanmhasrup.splashify.internal.SplashScreenStateManager

@Composable
fun SplashifyApp(
    splashScreen: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    val splashScreenStateManager = remember { SplashScreenStateManager() }

    CompositionLocalProvider(LocalSplashScreenStateManager provides splashScreenStateManager) {
        when {
            splashScreenStateManager.showSplashScreen -> {
                splashScreen()
            }

            else -> {
                content()
            }
        }
    }
}