package com.tbondarenko.pithagor.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tbondarenko.pithagor.ui.navigation.NavigationGraph
import com.tbondarenko.pithagor.ui.screens.common.SettingsBundle
import com.tbondarenko.pithagor.ui.screens.detail.DetailScreen
import com.tbondarenko.pithagor.ui.screens.detail.DetailViewModel
import com.tbondarenko.pithagor.ui.screens.main.MainScreen
import com.tbondarenko.pithagor.ui.screens.main.MainViewModel
import com.tbondarenko.pithagor.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val isDarkModeValue = false
            val currentStyle = rememberSaveable { mutableStateOf(PithagorStyle.Green) }
            val currentText = rememberSaveable { mutableStateOf(PithagorSize.Medium) }
            val currentShapeCorners = rememberSaveable { mutableStateOf(PithagorCorners.Rounded) }
            val isDarkMode = rememberSaveable { mutableStateOf(isDarkModeValue) }

            AppTheme(
                style = currentStyle.value,
                textSize = currentText.value,
                shapeCorners = currentShapeCorners.value,
                darkTheme = isDarkMode.value
            ) {
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()
                val systemBarColor = PithagorTheme.colors.controllerColors

                //Set status bar color
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = systemBarColor,
                        darkIcons = !isDarkMode.value
                    )
                }

                NavHost(
                    navController = navController,
                    startDestination = NavigationGraph.Main.name
                ) {
                    composable(NavigationGraph.Main.name) {
                        val settings = SettingsBundle(
                            isDarkMode = isDarkMode.value,
                            style = currentStyle.value,
                            textSize = currentText.value,
                            shapeCorners = currentShapeCorners.value
                        )
                        val mainViewModel = hiltViewModel<MainViewModel>()
                        MainScreen(
                            navController = navController,
                            mainViewModel = mainViewModel,
                            settings = settings,
                            onSettingsChanged = {
                                isDarkMode.value = it.isDarkMode
                                currentStyle.value = it.style
                                currentText.value = it.textSize
                                currentShapeCorners.value = it.shapeCorners
                            }
                        )
                    }
                    composable(
                        route = "${NavigationGraph.Detail.name}/{itemId}",
                        arguments = listOf(navArgument(name = "itemId") {
                            type = NavType.IntType
                        })
                    ) { backStackEntry ->
                        val detailViewModel = hiltViewModel<DetailViewModel>()
                        DetailScreen(
                            navController = navController,
                            itemId = backStackEntry.arguments?.getInt("itemId"),
                            detailViewModel = detailViewModel
                        )
                    }
                }
            }
        }
    }
}



