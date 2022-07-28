package com.tbondarenko.pithagor.ui.screens.main.models

data class MainViewState(
    val items: List<NumberCardItemModel> = emptyList(),
    val itemId: Int = -1,
    val isMultiply: Boolean = true,
)

