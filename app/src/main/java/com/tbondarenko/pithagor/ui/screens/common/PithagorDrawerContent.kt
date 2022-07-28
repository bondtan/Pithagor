package com.tbondarenko.pithagor.ui.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tbondarenko.pithagor.R
import com.tbondarenko.pithagor.ui.theme.*

@Composable
fun PithagorDrawerContent(
    modifier: Modifier = Modifier,
    settings: SettingsBundle,
    onSettingsChanged: (SettingsBundle) -> Unit
) {
    val (selectedOptionMode, onOptionSelectedMode) =
        remember { mutableStateOf(PithagorMode.Light) }
    val (selectedOptionCorner, onOptionSelectedCorner) =
        remember { mutableStateOf(PithagorCorners.Rounded) }
    val (selectedOptionSize, onOptionSelectedSize) =
        remember { mutableStateOf(PithagorSize.Medium) }
    val state = rememberScrollState()

    // App name
    Column(
        modifier = Modifier.verticalScroll(
            state = state
        )
    ) {
        Text(
            modifier = Modifier.padding(
                start = PithagorTheme.shape.padding,
                top = PithagorTheme.shape.padding * 2
            ),
            text = stringResource(id = R.string.app_name),
            style = PithagorTheme.typography.cardTitle
        )
        Divider(
            modifier = Modifier.offset(y = PithagorTheme.shape.padding / 2),
            color = PithagorTheme.colors.primaryText
        )
        // Settings
        Row(
            modifier = Modifier.padding(PithagorTheme.shape.padding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = stringResource(R.string.settings),
                tint = PithagorTheme.colors.primaryText

            )
            Text(
                modifier = Modifier.offset(x = PithagorTheme.shape.padding),
                text = stringResource(R.string.settings),
                style = PithagorTheme.typography.header
            )
        }
        SubTitle(text = stringResource(R.string.theme))
        Column(
            modifier = Modifier
                .offset(
                    x = PithagorTheme.shape.padding * 4,
                    y = PithagorTheme.shape.padding
                )
                .selectableGroup()
        ) {
            PithagorMode.values().forEach { text ->
                RowRadioButtonText(
                    selected = (text == selectedOptionMode),
                    onClick = {
                        onOptionSelectedMode(text)
                        onSettingsChanged.invoke(
                            when (text) {
                                PithagorMode.Light -> settings.copy(isDarkMode = false)
                                PithagorMode.Dark -> settings.copy(isDarkMode = true)
                            }
                        )
                    },
                    text = text.toString()
                )
            }
        }
        SubDivider()
        SubTitle(text = stringResource(R.string.appearance))
        DrawerButtonSwitchColor(
            isDarkModeValue = settings.isDarkMode,
            onClick = {
                onSettingsChanged.invoke(
                    settings.copy(style = PithagorStyle.Green)
                )
            },
            darkPalette = baseDarkPalette,
            lightPalette = baseLightPalette
        )
        DrawerButtonSwitchColor(
            isDarkModeValue = settings.isDarkMode,
            onClick = {
                onSettingsChanged.invoke(
                    settings.copy(style = PithagorStyle.Orange)
                )
            },
            darkPalette = orangeDarkPalette,
            lightPalette = orangeLightPalette
        )
        SubDivider()
        SubTitle(text = stringResource(R.string.shape))
        Column(
            modifier = Modifier
                .offset(
                    x = PithagorTheme.shape.padding * 4,
                    y = PithagorTheme.shape.padding
                )
                .selectableGroup()
        ) {
            PithagorCorners.values().forEach { text ->
                RowRadioButtonText(
                    selected = (text == selectedOptionCorner),
                    onClick = {
                        onOptionSelectedCorner(text)
                        onSettingsChanged.invoke(
                            when (text) {
                                PithagorCorners.Rounded -> settings.copy(shapeCorners = PithagorCorners.Rounded)
                                PithagorCorners.Square -> settings.copy(shapeCorners = PithagorCorners.Square)
                            }
                        )
                    },
                    text = text.toString()
                )
            }
        }
        SubDivider()
        SubTitle(text = stringResource(R.string.size))
        Column(
            modifier = Modifier
                .offset(
                    x = PithagorTheme.shape.padding * 4,
                    y = PithagorTheme.shape.padding
                )
                .selectableGroup()
        ) {
            PithagorSize.values().forEach { text ->
                RowRadioButtonText(
                    selected = (text == selectedOptionSize),
                    onClick = {
                        onOptionSelectedSize(text)
                        onSettingsChanged.invoke(
                            when (text) {
                                PithagorSize.Medium -> settings.copy(textSize = PithagorSize.Medium)
                                PithagorSize.Big -> settings.copy(textSize = PithagorSize.Big)
                            }
                        )
                    },
                    text = text.toString()
                )
            }
        }
    }
}

@Composable
fun DrawerButtonSwitchColor(
    isDarkModeValue: Boolean,
    onClick: () -> Unit,
    darkPalette: PithagorColors,
    lightPalette: PithagorColors
) {
    Button(
        modifier = Modifier
            .padding(
                top = PithagorTheme.shape.padding,
                start = PithagorTheme.shape.padding * 4,
                end = PithagorTheme.shape.padding * 4
            )
            .fillMaxWidth(),
        shape = PithagorTheme.shape.cornerStyle,
        border = BorderStroke(width = 2.dp, color = PithagorTheme.colors.primaryBackground),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isDarkModeValue) darkPalette.accentColor
            else lightPalette.accentColor
        ),
        onClick = onClick
    ) {}
}

@Composable
fun SubDivider() {
    Divider(
        modifier = Modifier.offset(y = PithagorTheme.shape.padding / 2),
        color = PithagorTheme.colors.primaryText,
        startIndent = PithagorTheme.shape.padding * 4
    )
}

@Composable
fun SubTitle(
    text: String
) {
    Text(
        modifier = Modifier.offset(
            x = PithagorTheme.shape.padding * 4,
            y = PithagorTheme.shape.padding
        ),
        text = text,
        fontWeight = FontWeight.Bold,
        style = PithagorTheme.typography.body
    )
}

@Composable
fun RowRadioButtonText(
    selected: Boolean,
    onClick: () -> Unit,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = selected,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = PithagorTheme.colors.primaryText,
                unselectedColor = PithagorTheme.colors.primaryText
            )
        )
        Text(
            text = text,
            style = PithagorTheme.typography.body
        )
    }
}

