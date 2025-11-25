package com.example.lab14.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Colores principales de Baldosita
object BaldositaColors {
    val Background = Color(0xFF0A0E27)
    val Surface = Color(0xFF1E2442)
    val Header = Color(0xFF1A1F3A)
    val AccentCyan = Color(0xFF00E5FF)
    val AccentGreen = Color(0xFF76FF03)
    val AccentPurple = Color(0xFF7C4DFF)
    val AccentBlue = Color(0xFF00ACC1)
    val TextPrimary = Color.White
    val TextSecondary = Color(0xFFB0BEC5)
    val TextTertiary = Color(0xFF9FA8DA)
    val Divider = Color(0xFF3A4266)
    val LightBlue = Color(0xFF64B5F6)
}

private val BaldositaDarkColorScheme = darkColorScheme(
    primary = BaldositaColors.AccentCyan,
    secondary = BaldositaColors.AccentPurple,
    tertiary = BaldositaColors.AccentGreen,
    background = BaldositaColors.Background,
    surface = BaldositaColors.Surface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color(0xFF0A0E27),
    onBackground = BaldositaColors.TextPrimary,
    onSurface = BaldositaColors.TextPrimary
)

@Composable
fun BaldositaTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = BaldositaDarkColorScheme,
        content = content
    )
}