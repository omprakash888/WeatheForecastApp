package com.example.weatherforecastapp.weather.data.remote.model

import com.example.weatherforecastapp.weather.domain.modal.City

data class Weather(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherItem>,
    val message: Double
)