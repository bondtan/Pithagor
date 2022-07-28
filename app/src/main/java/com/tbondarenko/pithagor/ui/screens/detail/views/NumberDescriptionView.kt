package com.tbondarenko.pithagor.ui.screens.detail.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.tbondarenko.pithagor.ui.screens.detail.models.DetailViewState
import com.tbondarenko.pithagor.ui.theme.PithagorTheme

@Composable
fun NumberDescriptionView(
    modifier: Modifier = Modifier,
    viewState: DetailViewState
) {
    val state = rememberScrollState()

    Column(
        modifier = Modifier.verticalScroll(state = state),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(PithagorTheme.shape.padding * 2))
        val numberDescription = viewState.numberDescription
        numberDescription.forEach {
            Text(
                modifier = Modifier.padding(bottom = PithagorTheme.shape.padding ),
                fontWeight = FontWeight.Bold,
                text = it,
                style = PithagorTheme.typography.body2
            )
        }
        Spacer(modifier = Modifier.padding(PithagorTheme.shape.padding * 4))
    }
}