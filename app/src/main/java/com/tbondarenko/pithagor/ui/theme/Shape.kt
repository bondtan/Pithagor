package com.tbondarenko.pithagor.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

val squareShape = PithagorShape(
    padding = 12.dp,
    cornerStyle = RoundedCornerShape(4.dp),
    cornerStyleDetailTitle = RoundedCornerShape(100.dp)
)

val roundedShape = squareShape.copy(
    cornerStyle = RoundedCornerShape(20.dp)
)
