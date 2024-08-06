package com.example.weatherforecastapp.weather.data.repositoryImpl

import com.example.weatherforecastapp.utils.ApiStates
import com.example.weatherforecastapp.weather.data.remote.WeatherApi
import com.example.weatherforecastapp.weather.data.remote.model.Weather
import com.example.weatherforecastapp.weather.domain.repository.BaseRepository
import com.example.weatherforecastapp.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api : WeatherApi
) : WeatherRepository, BaseRepository() {

    override suspend fun getWeather(country : String): Result<Weather> = safeApiCall {
        api.getWeather(country)
    }


}