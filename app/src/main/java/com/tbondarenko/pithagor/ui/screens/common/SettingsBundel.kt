package com.tbondarenko.pithagor.ui.screens.common

import com.tbondarenko.pithagor.ui.theme.PithagorCorners
import com.tbondarenko.pithagor.ui.theme.PithagorSize
import com.tbondarenko.pithagor.ui.theme.PithagorStyle

data class SettingsBundle(
    val isDarkMode: Boolean,
    val style: PithagorStyle,
    val textSize: PithagorSize,
    val shapeCorners: PithagorCorners
)

