package com.example.weatherforecastapp.weather.domain.repository

import com.example.weatherforecastapp.weather.data.remote.model.Weather

interface WeatherRepository {
    suspend fun getWeather(country : String) : Result<Weather>
}