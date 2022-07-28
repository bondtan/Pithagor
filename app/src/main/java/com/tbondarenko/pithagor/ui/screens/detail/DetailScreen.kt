package com.tbondarenko.pithagor.ui.screens.detail

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.tbondarenko.pithagor.ui.screens.common.PithagorDetailTopBar
import com.tbondarenko.pithagor.ui.screens.common.PithagorFloatingActionButton
import com.tbondarenko.pithagor.ui.screens.detail.models.DetailEvent
import com.tbondarenko.pithagor.ui.screens.detail.models.DetailViewState
import com.tbondarenko.pithagor.ui.screens.detail.views.DetailView
import com.tbondarenko.pithagor.ui.theme.PithagorTheme

@Composable
fun DetailScreen(
    navController: NavController,
    itemId: Int?,
    detailViewModel: DetailViewModel,
) {
    val viewState = detailViewModel.viewState.observeAsState(DetailViewState())
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { PithagorDetailTopBar(onMenuClick = {  navController.navigateUp() }) },
        floatingActionButton = {
            PithagorFloatingActionButton(
                isMultiply = viewState.value.isMultiply,
                onClickFAB = {
                    detailViewModel.obtainEvent(
                        DetailEvent.FabClick(
                            value = !viewState.value.isMultiply
                        )
                    )
                }
            )
        },
        backgroundColor = PithagorTheme.colors.primaryBackground,
        contentColor = PithagorTheme.colors.primaryText
    ) {
        DetailView(viewState = viewState.value, detailViewModel = detailViewModel, itemId = itemId)
    }
    SideEffect {
        Log.d("DetSE", "$viewState")
    }
}