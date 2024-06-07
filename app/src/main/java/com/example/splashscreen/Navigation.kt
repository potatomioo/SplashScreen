package com.example.splashscreen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun navigateScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "SplashScreen"
    ){
        composable("HomeScreen"){
            HomeScreen(navController)
        }
        composable("SplashScreen"){
            splash(navController = navController)
        }
    }
}