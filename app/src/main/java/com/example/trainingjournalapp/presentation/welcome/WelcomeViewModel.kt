package com.example.trainingjournalapp.presentation.welcome

import androidx.lifecycle.viewModelScope
import com.example.mvvcmbase.viewmodel.BaseRoutingViewModel
import com.example.trainingjournalapp.presentation.MainDestination
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