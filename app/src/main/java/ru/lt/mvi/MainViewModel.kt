package ru.lt.mvi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel : ViewModel() {

    private val _state = MutableLiveData<WaterCounterState>(WaterCounterState.Idle)

    val counterValue: LiveData<String> = _state.map { state ->
        when(state) {
            is WaterCounterState.Counter -> state.count.toString()
            else -> "0"
        }
    }

    fun increment() {
        val currentCount = (_state.value as? WaterCounterState.Counter)?.count ?: 0
        _state.value = WaterCounterState.Counter(currentCount + 1)
    }

    fun decrement() {
        val currentCount = (_state.value as? WaterCounterState.Counter)?.count ?: 0
        _state.value = if (currentCount > 0) WaterCounterState.Counter(currentCount - 1) else WaterCounterState.Counter(currentCount)
    }
}



