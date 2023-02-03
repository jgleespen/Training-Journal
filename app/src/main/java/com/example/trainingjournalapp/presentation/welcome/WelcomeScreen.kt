package com.example.trainingjournalapp.presentation.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
            val list = mutableListOf(1, 2, 3, 5, 5)

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    username: String,
    containerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
    onContainerColor: Color = MaterialTheme.colorScheme.onTertiaryContainer,
    eventReceiver: EventReceiver<WelcomeScreenViewEvent>
) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
    ) {
    }
    Text(username)
}