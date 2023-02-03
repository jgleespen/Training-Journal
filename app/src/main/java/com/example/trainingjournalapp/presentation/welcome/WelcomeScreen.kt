package com.example.trainingjournalapp.presentation.welcome

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import com.example.mvvcmbase.viewmodel.EventReceiver
import com.example.trainingjournalapp.R
import com.example.trainingjournalapp.presentation.common.ScreenBackground
import kotlinx.coroutines.ExperimentalCoroutinesApi

/** [ViewDelegate] pattern for composables, essentially the
 * delegate picks the view to display and then passes a reference
 * to the [ViewModel] as an [EventReciever] **/
@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun WelcomeViewDelegate(viewModel: WelcomeViewModel) {
    ScreenBackground {
        viewModel.viewState.collectAsState().value?.apply {
                WelcomeScreen(
                username = username?.let {
                    stringResource(R.string.welcome_message_username, it)
                } ?: stringResource(R.string.welcome_error_username),
                eventReceiver = viewModel)
/*
        when(this) {
            is WelcomeScreenViewState -> {
        WelcomeScreen(
            username = username?.let {
                stringResource(R.string.welcome_message_username, it)
            } ?: stringResource(R.string.welcome_error_username),
            eventReceiver = viewModel)
            }
        }
*/
        }

    }
}

@Composable
fun WelcomeScreen(
    username: String,
    eventReceiver: EventReceiver<WelcomeScreenViewEvent>
) {
    Text(username)
}