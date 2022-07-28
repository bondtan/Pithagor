package com.tbondarenko.pithagor.ui.screens.detail.models

data class DetailViewState(
    val number: Int = -1,
    val numberDescription: List<String> =  emptyList(),
    val isMultiply: Boolean = true,
)