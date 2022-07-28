package com.tbondarenko.pithagor.ui.screens.detail.views

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tbondarenko.pithagor.R
import com.tbondarenko.pithagor.ui.screens.detail.DetailViewModel
import com.tbondarenko.pithagor.ui.screens.detail.models.DetailEvent
import com.tbondarenko.pithagor.ui.screens.detail.models.DetailViewState
import com.tbondarenko.pithagor.ui.theme.PithagorTheme

@Composable
fun DetailView(
    modifier: Modifier = Modifier,
    itemId: Int?,
    viewState: DetailViewState,
    detailViewModel: DetailViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 120.dp),
            shape = RoundedCornerShape(bottomEnd = 120.dp, bottomStart = 120.dp),
            color = PithagorTheme.colors.secondaryBackground,
            contentColor = PithagorTheme.colors.primaryText,
            elevation = 8.dp
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Log.d("DetailView", "${viewState.number}")
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(
                        id = if (viewState.isMultiply) R.string.multiplication_detail
                        else R.string.division_detail
                    ),
                    style = PithagorTheme.typography.header
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "${viewState.number}",
                    style = PithagorTheme.typography.cardTitle
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { detailViewModel.obtainEvent(DetailEvent.PreviousClick) }) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    tint = PithagorTheme.colors.accentColor,
                    imageVector = Icons.Filled.ChevronLeft,
                    contentDescription = stringResource(R.string.button_previous)
                )
            }
            NumberDescriptionView(
                viewState = viewState
            )
            IconButton(
                onClick = { detailViewModel.obtainEvent(DetailEvent.NextClick)
                }) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    tint = PithagorTheme.colors.accentColor,
                    imageVector = Icons.Filled.ChevronRight,
                    contentDescription = stringResource(R.string.button_next)
                )
            }
        }
    }
    LaunchedEffect(key1 = true){
        itemId?.let { DetailEvent.LoadDetail(it) }?.let { detailViewModel.obtainEvent(it) }
    }
}
