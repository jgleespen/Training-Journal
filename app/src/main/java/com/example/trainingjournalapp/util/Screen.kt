package com.example.trainingjournalapp.util

sealed class Screen(val route: String) {
    object Welcome : Screen("Welcome")
    object Login : Screen("Login")
    object Register : Screen("Register")
}

