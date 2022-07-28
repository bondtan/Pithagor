package com.tbondarenko.pithagor.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    style: PithagorStyle = PithagorStyle.Green,
    textSize: PithagorSize = PithagorSize.Medium,
    shapeCorners: PithagorCorners = PithagorCorners.Square,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (darkTheme) {
        true -> {
            when (style) {
                PithagorStyle.Green -> baseDarkPalette
                PithagorStyle.Orange -> orangeDarkPalette
            }
        }
        false -> {
            when (style) {
                PithagorStyle.Green -> baseLightPalette
                PithagorStyle.Orange -> orangeLightPalette
            }
        }
    }

    val typography = when (textSize) {
        PithagorSize.Medium -> mediumTypography
        PithagorSize.Big -> bigTypography
    }

    val shapes = when (shapeCorners) {
        PithagorCorners.Square -> squareShape
        PithagorCorners.Rounded -> roundedShape
    }

        CompositionLocalProvider(
            LocalPithagorColors provides colors,
            LocalPithagorTypography provides typography,
            LocalPithagorShape provides shapes,
            content = content
        )
}