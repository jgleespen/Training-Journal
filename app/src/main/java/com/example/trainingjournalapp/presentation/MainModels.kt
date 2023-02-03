package com.example.trainingjournalapp.presentation

import com.example.mvvcmbase.models.Destination
import com.example.mvvcmbase.models.ViewEvent
import com.example.mvvcmbase.models.ViewState

/** [ViewState] for [MainViewModel] **/
sealed interface MainViewState : ViewState {
    object Authenticated : MainViewState
    object Unauthenticated : MainViewState
}

/** [ViewState] for [MainViewModel] **/
sealed interface MainViewEvent : ViewEvent {
}

/** [Destination] for [MainActivity] **/
sealed interface MainDestination : Destination {
    object NavigateUp : MainDestination
    object NavigateWelcome : MainDestination
}
