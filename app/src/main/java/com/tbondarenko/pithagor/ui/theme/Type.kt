package com.tbondarenko.pithagor.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val mediumTypography = PithagorTypography(
    header = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    ),
    body = TextStyle(fontSize = 18.sp),
    body2 = TextStyle(fontSize = 24.sp),
    toolbar = TextStyle(fontSize = 18.sp),
    cardTitle = TextStyle(
        fontSize = 56.sp,
        fontWeight = FontWeight.Bold
    ),
)

val bigTypography = PithagorTypography(
    header = TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    ),
    body = TextStyle(fontSize = 20.sp),
    body2 = TextStyle(fontSize = 24.sp),
    toolbar = TextStyle(fontSize = 20.sp),
    cardTitle = TextStyle(
        fontSize = 64.sp,
        fontWeight = FontWeight.Bold
    ),
)
