package io.github.sudarshanmhasrup.splashify

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import io.github.sudarshanmhasrup.splashify.internal.LocalSplashScreenStateManager
import io.github.sudarshanmhasrup.splashify.internal.SplashScreenStateManager

/**
 * Entry point for Splashify.
 *
 * Displays the splash screen first and switches to the main content when the splash screen is finished.
 *
 * Internally manages splash state and provides it to splash composables.
 *
 * @param splashScreen Composable shown as the splash screen.
 * @param content Composable shown after the splash screen completes.
 */
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