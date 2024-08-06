package com.example.weatherforecastapp.weather.presentation.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecastapp.weather.domain.usecases.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherScreenViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase
) : ViewModel() {

    var weatherState by mutableStateOf(WeatherScreenState())
        private set

    fun onEvent(event: WeatherScreenEvent) {
        when (event) {
            is WeatherScreenEvent.onQueryChange -> {
                weatherState = weatherState.copy(
                    country = event.query
                )
            }

            is WeatherScreenEvent.onGetData -> {
                getWeatherData()
            }

            else -> return
        }

    }

    private fun getWeatherData() {
        viewModelScope.launch {
            weatherState = weatherState.copy(
                isGettingWeatherData = true,
                weatherData = emptyList()
            )

            weatherUseCase
                .getWeather(weatherState.country)
                .onSuccess {
                    weatherState = weatherState.copy(
                        weatherData = listOf(it),
                        isGettingWeatherData = false,
                        country = ""
                    )
                }
                .onFailure {
                    weatherState = weatherState.copy(isGettingWeatherData = false)
                }
        }

    }

}