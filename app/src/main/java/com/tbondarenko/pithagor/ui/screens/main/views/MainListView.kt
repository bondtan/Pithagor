package com.tbondarenko.pithagor.ui.screens.main.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.tbondarenko.pithagor.ui.navigation.NavigationGraph
import com.tbondarenko.pithagor.ui.screens.main.models.MainViewState
import com.tbondarenko.pithagor.ui.theme.PithagorTheme
import com.tbondarenko.pithagor.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainListView(
    modifier: Modifier,
    navController: NavController,
    viewState: MainViewState,
) {
    var indexState = 0
    val state = rememberSaveable { mutableStateOf(indexState) }
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = state.value)
    Surface(
        modifier = modifier.fillMaxSize(),
        color = PithagorTheme.colors.primaryBackground
    ) {
        LazyColumn(
            modifier = Modifier,
            state = listState,
        ) {
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(PithagorTheme.colors.primaryBackground),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(PithagorTheme.shape.padding)
                            .background(
                                color = PithagorTheme.colors.secondaryBackground,
                                shape = PithagorTheme.shape.cornerStyle
                            ),
                        textAlign = TextAlign.Center,
                        text = if (viewState.isMultiply) stringResource(R.string.multiply)
                        else stringResource(id = R.string.divide),
                        color = PithagorTheme.colors.primaryText,
                        style = PithagorTheme.typography.header
                    )
                }
            }
            val numbers = viewState.items
            itemsIndexed(items = numbers) { index, number ->
                indexState = index
                NumberCardItem(
                    model = number,
                    onCardItemClick = {
                        navController.navigate("${NavigationGraph.Detail.name}/${number.numberId}") {
                            popUpTo(NavigationGraph.Main.name)
                        }
                    })
            }
        }
    }
}
