package com.tbondarenko.pithagor.ui.theme

import androidx.compose.ui.graphics.Color

val baseLightPalette = PithagorColors(
    primaryBackground = Color(0xFFCAECCD),
    secondaryBackground = Color(0xFFA8C59C),
    primaryText = Color(0xFF325F32),
    primaryInvertText = Color(0xFFFFFFFF),
    secondaryTexColor = Color(0xFF4F575E),
    accentColor = Color(0xFF28662D),
    errorColor = Color(0xFFB71C1C),
    controllerColors = Color(0xCCC2E0C5),
)

val baseDarkPalette = PithagorColors(
    primaryBackground = Color(0xFF273544),
    secondaryBackground = Color(0xFF23282D),
    primaryText = Color(0xFFB7D5AB),
    primaryInvertText = Color(0xFFE5EBE3),
    secondaryTexColor = Color(0xCC7A8A99),
    accentColor = Color(0xFF388E3C),
    errorColor = Color(0xFFF8BBD0),
    controllerColors = Color(0xFF273544),
)

val orangeLightPalette = baseLightPalette.copy(
    primaryBackground = Color(0xFFE2D5CB),
    secondaryBackground = Color(0xFFE0B99B),
    primaryText = Color(0xFF382312),
    accentColor = Color(0xFFFF6F00),
    controllerColors = Color(0xFFCFBEB0),
    )

val orangeDarkPalette = baseDarkPalette.copy(
    primaryText = Color(0xFFEECAAA),
    accentColor = Color(0xFFB85102),
)
