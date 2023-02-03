package com.example.trainingjournalapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.example.mvvcmbase.viewmodel.Router
import com.example.trainingjournalapp.presentation.MainDestination.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trainingjournalapp.presentation.theme.TrainingJournalAppTheme
import com.example.trainingjournalapp.util.Screen.*
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

/** In this MVVM architecture, [MainActivity] serves us as a navigation point by inheriting the
 * abstracted viewModel class [Router]
 * [MainActivity] also serves as a kind of origin point for the [navController], [MainViewModel]**/
@AndroidEntryPoint
@OptIn(ExperimentalCoroutinesApi::class, ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity(), Router<MainDestination> {

    private lateinit var navController: NavHostController

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            TrainingJournalAppTheme {
                viewModel = hiltViewModel()

                viewModel.apply {
                    navController = rememberAnimatedNavController()
                    viewState.collectAsState().value?.apply {
/*
                        val startScreen = if (it is MainViewState.Authenticated) {
                            Welcome.route
                        } else {
                            Login.route
                        }
*/
                        /** Value of [startScreen] determines initial route**/
                        /** Value of [startScreen] determines initial route**/
                        val startScreen = Welcome.route
                        TrainingJournalAppTheme() {
                            MainNavHost(
                                navController = navController,
                                startRoute = startScreen,
                                router = this@MainActivity
                            )
                        }
                    }
                }
            }
        }
    }

    /** Add new [destination] connections here **/
    override fun routeTo(destination: MainDestination) {
        when (destination) {
            is NavigateUp -> navigateUp()
            is NavigateWelcome -> navigateWelcome()
        }
    }

    /** [navigateUp] in android indicates moving backwards in the backstack **/
    private fun navigateUp() {
        navController.navigateUp()
    }


    /** Navigate to [WelcomeScreen] **/
    private fun navigateWelcome() {
        navController.navigate(route = Welcome.route) {
            popUpTo(route = Register.route) {
                inclusive = true
            }
            popUpTo(route = Login.route) {
                inclusive = true
            }
        }
    }
}
