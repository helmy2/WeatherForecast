package com.example.weather_forecast.domain.repository

import com.example.weather_forecast.domain.model.WeatherInfo
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherData(): Flow<WeatherInfo>
}