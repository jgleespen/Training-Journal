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
import androidx.compose.ui.unit.dp
import com.example.mvvcmbase.viewmodel.EventReceiver
import com.example.trainingjournalapp.presentation.common.AppScaffold
import com.example.trainingjournalapp.presentation.common.ScreenBackground
import kotlinx.coroutines.ExperimentalCoroutinesApi

/** [ViewDelegate] pattern for composables, essentially the
 * delegate picks the view to display and then passes a reference
 * to the [ViewModel] as an [EventReciever] **/
@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun WelcomeViewDelegate(viewModel: WelcomeViewModel) {
    ScreenBackground {
        AppScaffold(
            topBar = { /*TODO*/ },
            bottomBar = { /*TODO*/ },
        ) {
            viewModel.viewState.collectAsState().value?.apply {
                WelcomeScreen(eventReceiver = viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    eventReceiver: EventReceiver<WelcomeScreenViewEvent>
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
    ) {
    }
}