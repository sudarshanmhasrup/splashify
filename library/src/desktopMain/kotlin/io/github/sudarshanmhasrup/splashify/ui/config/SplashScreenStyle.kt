package io.github.sudarshanmhasrup.splashify.ui.config

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines the visual style of the splash screen.
 *
 * @param backgroundColor Background color of the splash screen.
 * @param cornerRadius Corner radius of the splash screen.
 */
data class SplashScreenStyle(
    val backgroundColor: Color = Color.White,
    val cornerRadius: Dp = 8.dp
)