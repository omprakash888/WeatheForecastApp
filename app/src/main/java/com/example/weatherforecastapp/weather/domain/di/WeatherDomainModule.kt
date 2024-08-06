package com.example.weatherforecastapp.weather.domain.di

import com.example.weatherforecastapp.weather.domain.repository.WeatherRepository
import com.example.weatherforecastapp.weather.domain.usecases.GetWeatherForCountry
import com.example.weatherforecastapp.weather.domain.usecases.WeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object WeatherDomainModule {

    @ViewModelScoped
    @Provides
    fun provideWeatherUseCase(
        repository: WeatherRepository
    ) : WeatherUseCase {

        return WeatherUseCase(
            getWeather = GetWeatherForCountry(repository)
        )
    }
}