package ru.lt.mvi

sealed class WaterCounterState {
    object Idle : WaterCounterState()
    data class Counter(val count: Int) : WaterCounterState()
}
