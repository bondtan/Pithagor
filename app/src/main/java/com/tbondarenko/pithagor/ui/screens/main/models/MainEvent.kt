package com.tbondarenko.pithagor.ui.screens.main.models

sealed class MainEvent {
    object ShowData : MainEvent()
    data class NumberClick(val value: Int): MainEvent()
    data class FabClick(val value: Boolean) :MainEvent()
}