package com.sample.app

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.sudarshanmhasrup.splashify.ui.config.SplashScreenSize
import io.github.sudarshanmhasrup.splashify.ui.config.SplashScreenStyle
import io.github.sudarshanmhasrup.splashify.ui.splashscreen.SimpleSplashScreen

@Composable
fun SplashScreen() {
    val size = SplashScreenSize(width = 600.dp, height = 380.dp)
    val style = SplashScreenStyle(cornerRadius = 16.dp, backgroundColor = Color.Black)

    SimpleSplashScreen(size = size, style = style) {
        Text(text = "Splashify", fontSize = 28.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
    }
}