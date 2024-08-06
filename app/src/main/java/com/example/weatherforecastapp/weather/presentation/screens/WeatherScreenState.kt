package com.example.weatherforecastapp.weather.presentation.screens

import com.example.weatherforecastapp.weather.data.remote.model.Weather

data class WeatherScreenState(
    val country : String = "india",
    val isGettingWeatherData : Boolean = false,
    val weatherData : List<Weather> = emptyList()
)
