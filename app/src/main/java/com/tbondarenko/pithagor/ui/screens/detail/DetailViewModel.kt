package com.tbondarenko.pithagor.ui.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbondarenko.pithagor.common.EventHandler
import com.tbondarenko.pithagor.domain.Repository
import com.tbondarenko.pithagor.ui.screens.detail.models.DetailEvent
import com.tbondarenko.pithagor.ui.screens.detail.models.DetailViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: Repository
) :
    ViewModel(), EventHandler<DetailEvent> {

    private val _number = MutableLiveData(-1)
    private val number: LiveData<Int> = _number
    private val _viewState = MutableLiveData(DetailViewState())
    val viewState: LiveData<DetailViewState> = _viewState

    override fun obtainEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.FabClick -> switchMultiplyDivide(event.value)
            is DetailEvent.LoadDetail -> loadDetailScreen(event.value)
            DetailEvent.PreviousClick -> showPreviousNumber()
            DetailEvent.NextClick -> showNextNumber()
        }
    }

    private fun loadDetailScreen(value: Int) {
        _number.value = value
        number.value?.let { fetchDataItem(value = it) }
    }

    private fun showNextNumber() {
        val newNumber = when (val oldNumber = _viewState.value?.number ?: -1) {
            in 1..9 -> oldNumber.plus(1)
            else -> 1
        }
        fetchDataItem(newNumber)
    }

    private fun showPreviousNumber() {
        val newNumber = when (val oldNumber = _viewState.value?.number ?: -1) {
            in 2..10 -> oldNumber.minus(1)
            else -> 10
        }
        fetchDataItem(newNumber)
    }


    private fun switchMultiplyDivide(value: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            val item = _viewState.value?.let { getItem(it.number, value) }
            _viewState.postValue(item?.let {
                _viewState.value?.copy(
                    numberDescription = it,
                    isMultiply = value
                )
            })
        }
    }

    private fun fetchDataItem(value: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val isMultiply = _viewState.value?.isMultiply ?: true
            val item = getItem(value, isMultiply)
            _viewState.postValue(
                _viewState.value?.copy(
                    numberDescription = item,
                    number = value
                )
            )
        }
    }

    private fun getItem(numberId: Int, isMultiply: Boolean): List<String> {
        val number = repository.fetchNumber(numberId)
        return if (isMultiply) number.multiply
        else number.divide
    }
}