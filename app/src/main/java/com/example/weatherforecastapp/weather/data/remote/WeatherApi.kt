package com.example.weatherforecastapp.weather.data.remote

import com.example.weatherforecastapp.utils.Constants
import com.example.weatherforecastapp.weather.data.remote.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {

    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query(value = "q") query: String,
        @Query(value = "units") units : String = "imperial",
        @Query(value = "appId") appId : String = Constants.API_KEY
    ) : Response<Weather>



}