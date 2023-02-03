package com.example.trainingjournalapp.presentation.common

import android.graphics.Color
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.trainingjournalapp.presentation.theme.spacing

@Composable
fun ScreenBackground(
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = CenterHorizontally,
    padding: Dp = 10.dp,
    scrollState: ScrollState? = rememberScrollState(),
    scrollingEnabled: Boolean = true,
    verticalArrangement: Arrangement.Vertical = spacedBy(
        space = spacing.medium,
        alignment = CenterVertically
    ),
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        content = content,
        horizontalAlignment = horizontalAlignment,
        modifier = modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.White)
            .run { if (scrollingEnabled) scrollState?.let { verticalScroll(it) } ?: this else this }
            .padding(padding),
        verticalArrangement = verticalArrangement
    )
}
