package com.juandavidbernalsantoyo.exploracolombiaapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth

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

        composable(route = "home") {
            HomeScreen(
                onSignOut = {
                    myNavController.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }
    }
}