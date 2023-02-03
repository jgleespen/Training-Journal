package com.example.trainingjournalapp.presentation.navhost

import androidx.lifecycle.viewModelScope
import com.example.mvvcmbase.viewmodel.BaseViewModel
import com.example.trainingjournalapp.domain.usecases.authentication.GetUserUseCase
import com.example.trainingjournalapp.presentation.navhost.MainViewState.*
import com.example.trainingjournalapp.util.doOnError
import com.example.trainingjournalapp.util.doOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/** [MainViewModel] works on conjunction with MainActivity to initialize the app state and authenticate the user
 * [ViewModel] classes should always extend [BaseViewModel]**/
@HiltViewModel
class MainViewModel @Inject constructor(
    //getUserUseCase: GetUserUseCase
) : BaseViewModel<MainViewState, MainViewEvent>() {

    /** All [HiltViewModel] classes can implement an init block.
     * In this case we just call our [getUserUseCase] to check for a logged in use.
     * The use case either returns [Response.Success] or [Response.Error] which we
     * subsequently call associated extension functions to apply our state to the [MainViewModel]
     */
    init {
        viewModelScope.launch {
            Authenticated.push()
        }
    }

    /** Event receiving function, no actual functionality should be in this.
     * It is empty and likely will be forever as there is not very many
     * things that are required by the [MainViewModel]**/
    override fun onEvent(event: MainViewEvent) {
    }
}
