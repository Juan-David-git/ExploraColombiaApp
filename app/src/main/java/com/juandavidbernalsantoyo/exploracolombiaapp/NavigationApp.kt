package com.juandavidbernalsantoyo.exploracolombiaapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.juandavidbernalsantoyo.exploracolombiaapp.ui.elements.AddPlaceScreen
import com.juandavidbernalsantoyo.exploracolombiaapp.ui.elements.HomeScreen
import com.juandavidbernalsantoyo.exploracolombiaapp.ui.elements.LoginScreen
import com.juandavidbernalsantoyo.exploracolombiaapp.ui.elements.RegisterScreen

@Composable
fun NavigationApp() {
    val myNavController = rememberNavController()

    // Verificar si ya hay una sesión activa
    val currentUser = FirebaseAuth.getInstance().currentUser
    val startDestination = if (currentUser != null) "home" else "login"

    NavHost(
        navController = myNavController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = "login") {
            LoginScreen(
                onLoginSuccess = {
                    myNavController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    myNavController.navigate("register")
                }
            )
        }

        composable(route = "register") {
            RegisterScreen(
                onRegisterSuccess = {
                    myNavController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    myNavController.popBackStack()
                },
                onBackClick = {
                    myNavController.popBackStack()
                }
            )
        }

        composable("home") {
            HomeScreen(
                onNavigateToAddPlace = { myNavController.navigate("add_place") }
            )
        }
        composable(route = "add_place") {
            AddPlaceScreen(
                onBackClick = { myNavController.popBackStack() }
            )
        }
    }
}


