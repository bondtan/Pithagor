package com.tbondarenko.pithagor.ui.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbondarenko.pithagor.common.EventHandler
import com.tbondarenko.pithagor.domain.Repository
import com.tbondarenko.pithagor.ui.screens.main.models.MainEvent
import com.tbondarenko.pithagor.ui.screens.main.models.MainViewState
import com.tbondarenko.pithagor.ui.screens.main.models.NumberCardItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(), EventHandler<MainEvent> {

    private val _viewState = MutableLiveData(MainViewState())
    val viewState: LiveData<MainViewState> = _viewState

    init {
        fetchData()
    }

    override fun obtainEvent(event: MainEvent) {
        when (event) {
            MainEvent.ShowData -> fetchData()
            is MainEvent.FabClick -> switchMultiplyDivide(event.value)
            is MainEvent.NumberClick -> switchToDetailScreen(event.value)
        }
    }

    private fun switchMultiplyDivide(value: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            val cardItems = getCardItems(value)
            _viewState.postValue(_viewState.value?.copy(items = cardItems, isMultiply = value))
        }
    }

    private fun switchToDetailScreen(value: Int) {
        _viewState.postValue(_viewState.value?.copy(itemId = value))
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val isMultiply = _viewState.value?.isMultiply ?: true
            val cardItems = getCardItems(isMultiply)
            _viewState.postValue(_viewState.value?.copy(items = cardItems))
        }
    }

    private fun getCardItems(isMultiply: Boolean): List<NumberCardItemModel> {
        val pithagor = repository.pithagorTable
        return pithagor.map { number ->
            NumberCardItemModel(
                numberId = number.numberId,
                numberDescription = if (isMultiply) number.multiply
                else number.divide
            )
        }
    }
}