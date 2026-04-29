package io.github.sudarshanmhasrup.splashify.ui.config

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines the style of the progress indicator used in the splash screen.
 *
 * @param color Color of the progress indicator.
 * @param trackColor Background track color of the indicator.
 * @param thickness Thickness of the indicator.
 */
data class SplashIndicatorStyle(
    val color: Color = Color.White,
    val trackColor: Color = Color.Gray,
    val thickness: Dp = 4.dp
)