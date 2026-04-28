package io.github.sudarshanmhasrup.splashify.ui.splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import io.github.sudarshanmhasrup.splashify.internal.LocalSplashScreenStateManager
import io.github.sudarshanmhasrup.splashify.ui.config.SplashScreenSize
import io.github.sudarshanmhasrup.splashify.ui.config.SplashScreenStyle
import kotlin.system.exitProcess

/**
 * Displays a simple splash screen window for Compose Multiplatform desktop apps.
 *
 * Allows customizing size and style, and provides a slot to render custom UI content.
 *
 * @param size Size of the splash screen window.
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
        onCloseRequest = {  }
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