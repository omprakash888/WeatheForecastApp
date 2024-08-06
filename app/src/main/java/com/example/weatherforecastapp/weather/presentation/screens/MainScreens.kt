package com.example.weatherforecastapp.weather.presentation.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreens(
    viewModel: WeatherScreenViewModel = hiltViewModel()
) {
    val state = viewModel.weatherState
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        color = Color.White
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                viewModel.onEvent(WeatherScreenEvent.onGetData)

            }) {
                Text(text = "Get Weather Data")
            }
            ShowData(state)
        }
    }

}

@Composable
fun ShowData(state: WeatherScreenState) {

    if (state.isGettingWeatherData) {
        //CircularProgressIndicator()
        Log.d("Check", "okokokok")
    }
    else if (state.weatherData.isNotEmpty()){
        val weatherData = state.weatherData[0]

        Text(text = "Main Screen ${weatherData.message}, ${weatherData.city}, ${weatherData.cod}")
    }
}