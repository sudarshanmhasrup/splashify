package io.github.sudarshanmhasrup.splashify.ui.config

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines the size of the splash screen window.
 *
 * @param width Width of the splash screen window.
 * @param height Height of the splash screen window.
 */
data class SplashScreenSize(
    val width: Dp = 700.dp,
    val height: Dp = 480.dp
)