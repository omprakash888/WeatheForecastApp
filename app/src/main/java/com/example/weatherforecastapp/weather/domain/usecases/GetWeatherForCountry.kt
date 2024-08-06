package com.example.weatherforecastapp.weather.domain.usecases

import com.example.weatherforecastapp.weather.data.remote.model.Weather
import com.example.weatherforecastapp.weather.domain.repository.WeatherRepository

class GetWeatherForCountry(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(
        country: String
    ): Result<Weather> {
        return repository.getWeather(country)
    }


}