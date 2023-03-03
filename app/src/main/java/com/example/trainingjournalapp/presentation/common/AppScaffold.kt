package com.example.trainingjournalapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trainingjournalapp.presentation.theme.LocalSpacing
import com.example.trainingjournalapp.presentation.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    topBarTitle: String = "Placeholder",
    bottomBar: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(topBarTitle) },
                modifier = Modifier.border(2.dp, MaterialTheme.colorScheme.primary),
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
            )
        },
        bottomBar = bottomBar,
        content = content
    )
}