package com.tbondarenko.pithagor.ui.screens.common

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.tbondarenko.pithagor.R
import com.tbondarenko.pithagor.ui.theme.PithagorTheme

@Composable
fun PithagorFloatingActionButton(
    modifier: Modifier = Modifier,
    isMultiply: Boolean,
    onClickFAB: () -> Unit
) {
    ExtendedFloatingActionButton(
        backgroundColor = PithagorTheme.colors.accentColor,
        text = {
            Text(
                text = if (isMultiply) stringResource(R.string.divide).uppercase()
                else stringResource(R.string.multiply).uppercase(),
                fontWeight = FontWeight.Bold,
                style = PithagorTheme.typography.body
            )
        },
        onClick = onClickFAB,
        contentColor = PithagorTheme.colors.primaryInvertText)
}