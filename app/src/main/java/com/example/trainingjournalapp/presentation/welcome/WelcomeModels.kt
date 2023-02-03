package com.example.trainingjournalapp.presentation.welcome

import com.example.mvvcmbase.models.ViewEvent
import com.example.mvvcmbase.models.ViewState

data class WelcomeScreenViewState(
    val username: String?,
) : ViewState

sealed interface WelcomeScreenViewEvent : ViewEvent {
    object ClickedMenu : WelcomeScreenViewEvent
}