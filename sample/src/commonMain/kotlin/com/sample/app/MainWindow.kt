package com.sample.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import kotlin.system.exitProcess

@Composable
fun MainWindow(modifier: Modifier = Modifier) {
    Window(
        title = "Splashify Demo",
        onCloseRequest = { exitProcess(status = 0) }
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello, this is a demo screen for Splashify.", fontSize = 16.sp)
        }
    }
}