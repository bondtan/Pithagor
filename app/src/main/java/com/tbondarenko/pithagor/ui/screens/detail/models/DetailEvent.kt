package com.tbondarenko.pithagor.ui.screens.detail.models

sealed class DetailEvent {
    data class LoadDetail(val value: Int) : DetailEvent()
    data class FabClick(val value: Boolean) : DetailEvent()
    object PreviousClick : DetailEvent()
    object NextClick : DetailEvent()
}