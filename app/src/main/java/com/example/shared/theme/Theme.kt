package com.example.shared.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val DarkColorScheme = darkColorScheme(
  primary = PrismaDarkPrimary,
  secondary = PrismaDarkPrimary, // Accentuate with singular brand color
  background = PrismaDarkBackground,
  surface = PrismaDarkSurface,
  onPrimary = PrismaDarkOnPrimary,
  onBackground = PrismaDarkOnBackground,
  onSurface = PrismaDarkOnSurface,
  surfaceVariant = PrismaDarkSurface,
  onSurfaceVariant = PrismaDarkOnSurfaceMuted
)

private val LightColorScheme = lightColorScheme(
  primary = PrismaPrimary,
  secondary = PrismaPrimary, // Accentuate with singular brand color
  background = PrismaBackground,
  surface = PrismaSurface,
  onPrimary = PrismaOnPrimary,
  onBackground = PrismaOnBackground,
  onSurface = PrismaOnSurface,
  surfaceVariant = PrismaSurface,
  onSurfaceVariant = PrismaOnSurfaceMuted
)

val PrismaShapes = Shapes(
  small = RoundedCornerShape(8.dp),
  medium = RoundedCornerShape(12.dp),  // Perfect light rounding for cards and menus
  large = RoundedCornerShape(16.dp)    // Generous but clean rounding for main components
)

@Composable
fun PrismaTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    shapes = PrismaShapes,
    content = content
  )
}
