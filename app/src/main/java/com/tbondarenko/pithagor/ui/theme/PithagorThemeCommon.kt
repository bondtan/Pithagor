package com.tbondarenko.pithagor.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class PithagorColors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val primaryText: Color,
    val primaryInvertText: Color,
    val secondaryTexColor: Color,
    val accentColor: Color,
    val errorColor: Color,
    val controllerColors: Color,
)

data class PithagorTypography(
    val header: TextStyle,
    val body: TextStyle,
    val body2: TextStyle,
    val toolbar: TextStyle,
    val cardTitle: TextStyle
)

data class PithagorShape(
    val padding: Dp,
    val cornerStyle: Shape,
    val cornerStyleDetailTitle:Shape
    )

enum class PithagorMode{
    Light, Dark
}

enum class PithagorStyle{
    Green, Orange
}
enum class PithagorSize{
    Medium, Big
}
enum class PithagorCorners{
    Square, Rounded
}

object PithagorTheme {
    val colors: PithagorColors
    @Composable
    get() = LocalPithagorColors.current

    val typography: PithagorTypography
    @Composable
    get() = LocalPithagorTypography.current

    val shape: PithagorShape
    @Composable
    get() = LocalPithagorShape.current
}

val LocalPithagorColors = staticCompositionLocalOf<PithagorColors>{
    error("No colors provided")
}

val LocalPithagorTypography = staticCompositionLocalOf<PithagorTypography>{
    error("No typography provided")
}

val LocalPithagorShape = staticCompositionLocalOf<PithagorShape>{
    error("No shape provided")
}