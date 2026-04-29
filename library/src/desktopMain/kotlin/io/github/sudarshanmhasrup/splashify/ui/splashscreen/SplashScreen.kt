package io.github.sudarshanmhasrup.splashify.ui.splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import io.github.sudarshanmhasrup.splashify.internal.LocalSplashScreenStateManager
import io.github.sudarshanmhasrup.splashify.ui.config.SplashIndicatorStyle
import io.github.sudarshanmhasrup.splashify.ui.config.SplashScreenSize
import io.github.sudarshanmhasrup.splashify.ui.config.SplashScreenStyle

/**
 * Displays a simple splash screen for Compose Multiplatform desktop apps.
 *
 * Allows customizing size and style, and provides a slot to render custom UI content.
 *
 * @param size Size of the splash screen.
 * @param style Visual style of the splash screen.
 * @param content Composable content shown inside the splash screen. Provides current loader progress if needed.
 */
@Composable
fun SimpleSplashScreen(
    size: SplashScreenSize = SplashScreenSize(),
    style: SplashScreenStyle = SplashScreenStyle(),
    content: @Composable (Float) -> Unit
) {
    val windowState = WindowState(
        width = size.width,
        height = size.height,
        position = WindowPosition(alignment = Alignment.Center)
    )

    val backgroundModifier = Modifier
        .clip(shape = RoundedCornerShape(size = style.cornerRadius))
        .background(color = style.backgroundColor)
        .fillMaxSize()

    val splashScreenStateManager = LocalSplashScreenStateManager.current

    Window(
        resizable = false,
        focusable = false,
        undecorated = true,
        transparent = true,
        alwaysOnTop = true,
        state = windowState,
        onCloseRequest = { }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = backgroundModifier
        ) {
            content(splashScreenStateManager.loaderProgress)
        }
    }
}

/**
 * Displays a splash screen with a progress indicator.
 *
 * Allows custom content in the center and shows progress at the bottom.
 *
 * @param size Size of the splash screen.
 * @param style Visual style of the splash screen.
 * @param indicatorStyle Visual style of the progress indicator.
 * @param content Composable content shown above the progress indicator.
 */
@Composable
fun ProgressiveSplashScreen(
    size: SplashScreenSize = SplashScreenSize(),
    style: SplashScreenStyle = SplashScreenStyle(),
    indicatorStyle: SplashIndicatorStyle = SplashIndicatorStyle(),
    content: @Composable () -> Unit
) {
    SimpleSplashScreen(size = size, style = style) { progress ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ) {
            val contentBackgroundModifier = Modifier
                .fillMaxWidth()
                .weight(1f)

            Box(contentAlignment = Alignment.Center, modifier = contentBackgroundModifier) {
                content()
            }
            LinearProgressIndicator(
                progress = { progress },
                color = indicatorStyle.color,
                trackColor = indicatorStyle.trackColor,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}