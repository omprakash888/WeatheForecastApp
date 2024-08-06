package com.example.weatherforecastapp.weather.presentation.screens

sealed class WeatherScreenEvent {
    data class onQueryChange(val query : String) : WeatherScreenEvent()
    object onGetData : WeatherScreenEvent()
}