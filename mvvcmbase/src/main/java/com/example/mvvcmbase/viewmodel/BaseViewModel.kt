package com.example.mvvcmbase.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvcmbase.models.ViewEvent
import com.example.mvvcmbase.models.ViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


@OptIn(ExperimentalCoroutinesApi::class)
abstract class BaseViewModel<TypeOfViewState : ViewState, TypeOfViewEvent : ViewEvent> :
    ViewModel(), EventReceiver<TypeOfViewEvent>, StatePusher<TypeOfViewState> {

    companion object {
        /** Minimum duration between two debounced events in milliseconds **/
        private const val DEBOUNCE_TIME_MS = 1000L
    }

    private var lastDebouncedTime: Long = Long.MIN_VALUE

    /** Utility for implementing [ViewModel] **/
    val lastPushedState: TypeOfViewState?
        get() = viewState.value

    /** Private mutable and public immutable [ViewState] **/
    private var _viewState: MutableStateFlow<TypeOfViewState?> = MutableStateFlow(null)
    final override val viewState: StateFlow<TypeOfViewState?> = _viewState

    final override fun onEventDebounced(event: TypeOfViewEvent) {
        val currTime = System.currentTimeMillis()
        if (currTime > lastDebouncedTime + DEBOUNCE_TIME_MS) {
            lastDebouncedTime = currTime
            onEvent(event)
        }
    }

    final override fun TypeOfViewState.push() {
        pushState(this)
    }

    final override fun pushState(state: TypeOfViewState) {
        _viewState.value = state
    }
}
