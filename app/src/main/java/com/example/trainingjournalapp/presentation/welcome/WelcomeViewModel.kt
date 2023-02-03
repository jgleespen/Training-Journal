package com.example.trainingjournalapp.presentation.welcome

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvcmbase.viewmodel.BaseRoutingViewModel
import com.example.trainingjournalapp.domain.usecases.authentication.GetUserUseCase
import com.example.trainingjournalapp.presentation.navhost.MainDestination
import com.example.trainingjournalapp.util.doOnError
import com.example.trainingjournalapp.util.doOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    //getUserUseCase: GetUserUseCase
) : BaseRoutingViewModel<WelcomeScreenViewState, WelcomeScreenViewEvent, MainDestination>() {
    init {
        viewModelScope.launch {
            WelcomeScreenViewState(
                username = "Bruh"
                /** Data implicitly in scope from [doOnSuccess] **/
            ).push()
        }
    }


    override fun onEvent(event: WelcomeScreenViewEvent) {

    }
}