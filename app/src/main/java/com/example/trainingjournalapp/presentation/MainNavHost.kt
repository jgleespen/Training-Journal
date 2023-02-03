package com.example.trainingjournalapp.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mvvcmbase.viewmodel.Router
import com.example.trainingjournalapp.presentation.welcome.WelcomeViewDelegate
import com.example.trainingjournalapp.presentation.welcome.WelcomeViewModel
import com.example.trainingjournalapp.util.Screen.*
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable


/** [MainNavHost] serves as an invokation point for all other composed content
 * Utilizes [AnimatedNavHost] library from Accompanist to remove awkward look of
 * the top bar fading in and out.
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavHost(
    navController: NavHostController,
    startRoute: String,
    router: Router<MainDestination>
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startRoute
    ) {

        /** Repeat pattern below for subsequent screens. We invoke the [viewModel] respective
         * to the screen we are navigating to.
         * The [apply] block puts you into an implicit block that is scoped to its calling object,
         * and applies code inside of scoped block to the caller.**/
        composable(route = Welcome.route) {
            WelcomeViewDelegate(viewModel = hiltViewModel<WelcomeViewModel>().apply {
                attachRouter(router)
            })
        }
    }
}
