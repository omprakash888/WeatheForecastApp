package com.example.weatherforecastapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherforecastapp.weather.presentation.screens.MainScreens
import com.example.weatherforecastapp.weather.presentation.screens.SplashScreens

@Composable
fun WeatherNavigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WeatherScreens.SplashScreen.name
    ) {
        composable(WeatherScreens.SplashScreen.name) {
            SplashScreens(onNextClick = {
                navController.popBackStack()
                navController.navigate(WeatherScreens.MainScreen.name)
            })
        }

        composable(WeatherScreens.MainScreen.name) {
            MainScreens()
        }


    }

}