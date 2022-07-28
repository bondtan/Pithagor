package com.tbondarenko.pithagor.ui.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.tbondarenko.pithagor.ui.screens.common.PithagorDrawerContent
import com.tbondarenko.pithagor.ui.screens.common.PithagorFloatingActionButton
import com.tbondarenko.pithagor.ui.screens.common.PithagorTopBar
import com.tbondarenko.pithagor.ui.screens.common.SettingsBundle
import com.tbondarenko.pithagor.ui.screens.main.models.MainEvent
import com.tbondarenko.pithagor.ui.screens.main.models.MainViewState
import com.tbondarenko.pithagor.ui.screens.main.views.MainListView
import com.tbondarenko.pithagor.ui.theme.PithagorTheme
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    mainViewModel: MainViewModel,
    settings: SettingsBundle,
    onSettingsChanged: (SettingsBundle) -> Unit
) {

    val viewState = mainViewModel.viewState.observeAsState(MainViewState())
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            PithagorTopBar(
                onMenuClick = {
                    scope.launch { scaffoldState.drawerState.open() }
                },
                isMenuClick = scaffoldState.drawerState.isOpen
            )
        },
        floatingActionButton = {
            PithagorFloatingActionButton(
                isMultiply = viewState.value.isMultiply,
                onClickFAB = {
                    mainViewModel.obtainEvent(
                        MainEvent.FabClick(
                            value = !viewState.value.isMultiply
                        )
                    )
                }
            )
        },
        drawerContent = {
            PithagorDrawerContent(
                settings = settings,
                onSettingsChanged = onSettingsChanged
            )
        },
        drawerBackgroundColor = PithagorTheme.colors.secondaryBackground,
        drawerElevation = PithagorTheme.shape.padding,
        drawerContentColor = PithagorTheme.colors.primaryText,
        contentColor = PithagorTheme.colors.primaryBackground
    )
    {
        MainListView(
            modifier = modifier,
            navController = navController,
            viewState = viewState.value
        )
    }
}
