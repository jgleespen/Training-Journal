package com.example.trainingjournalapp.presentation.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import com.example.trainingjournalapp.presentation.theme.spacing

/** [ViewDelegate] pattern for composables, essentially the
 * delegate picks the view to display and then passes a reference
 * to the [ViewModel] as an [EventReciever] **/
@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun WelcomeViewDelegate(viewModel: WelcomeViewModel) {
    AppScaffold(
        bottomBar = {
            BottomAppBar() {
            }
        },
    ) {
        ScreenBackground(scrollingEnabled = false) {
            viewModel.viewState.collectAsState().value?.apply {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    eventReceiver: EventReceiver<WelcomeScreenViewEvent>,
    shape: RoundedCornerShape = RoundedCornerShape(spacing.medium)
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
    }
}