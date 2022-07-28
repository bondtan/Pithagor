package com.tbondarenko.pithagor.ui.screens.common

import androidx.compose.foundation.layout.offset
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tbondarenko.pithagor.R
import com.tbondarenko.pithagor.ui.theme.AppTheme
import com.tbondarenko.pithagor.ui.theme.PithagorTheme

@Composable
fun PithagorTopBar(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit,
    isMenuClick: Boolean = false
) {
    TopAppBar(
        backgroundColor = PithagorTheme.colors.secondaryBackground,
        elevation = 8.dp
    ) {
        IconButton(onClick = onMenuClick) {
            Icon(
                imageVector = if (!isMenuClick) Icons.Filled.Menu
                else Icons.Filled.Close,
                contentDescription = if (isMenuClick) stringResource(R.string.open_menu)
                else stringResource(R.string.close_menu),
                tint = PithagorTheme.colors.accentColor
            )
        }
        Text(
            modifier = Modifier.offset(x = PithagorTheme.shape.padding / 2),
            text = stringResource(R.string.app_name),
            color = PithagorTheme.colors.primaryText,
            style = PithagorTheme.typography.header
        )
    }
}

@Composable
fun PithagorDetailTopBar(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit
) {
    TopAppBar(
        backgroundColor = PithagorTheme.colors.secondaryBackground,
        elevation = 8.dp
    ) {
        IconButton(onClick = onMenuClick) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(R.string.backup),
                tint = PithagorTheme.colors.accentColor
            )
        }
        Text(
            modifier = Modifier.offset(x = PithagorTheme.shape.padding / 2),
            text = stringResource(R.string.app_name),
            color = PithagorTheme.colors.primaryText,
            style = PithagorTheme.typography.header
        )
    }
}

@Preview(name = "First Preview", showBackground = true)
@Composable
fun PithagorTopBar_Preview() {
    AppTheme {
        PithagorTopBar(
            modifier = Modifier,
            onMenuClick = {},
            isMenuClick = false
        )
    }

}
