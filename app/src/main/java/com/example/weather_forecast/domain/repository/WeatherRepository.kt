package com.example.weather_forecast.domain.repository

import com.example.weather_forecast.data.local.model.WeatherDataDb
import com.example.weather_forecast.domain.model.WeatherDayDetails
import com.example.weather_forecast.domain.model.WeatherDetails
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherData(): Flow<List<WeatherDetails>>
    fun getCurrentWeatherInfo(): Flow<WeatherDetails>
    suspend fun updateData()
    fun getTodayWeatherInfo(): Flow<List<WeatherDataDb>>
    fun getDaysWeatherInfo(): Flow<List<WeatherDayDetails>>
}