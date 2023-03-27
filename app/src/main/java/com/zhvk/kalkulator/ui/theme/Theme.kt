package com.zhvk.kalkulator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val ColorPalette = lightColors(
    primary = OxfordBlue,
    primaryVariant = Black,
    secondary = Orange,
    background = OxfordBlue,
    surface = OxfordBlue,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
)

@Composable
fun KalkulatorTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = Black)
    
    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}