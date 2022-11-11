package com.example.weather_forecast.domain.repository

import com.example.weather_forecast.data.local.database.model.WeatherDataDb
import com.example.weather_forecast.domain.model.WeatherDayDetails
import com.example.weather_forecast.domain.model.WeatherDetails
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherData(): Flow<List<WeatherDetails>>
    fun getCurrentWeatherInfo(): Flow<WeatherDetails>
    suspend fun updateData(lat:Double,long:Double)
    fun getTodayWeatherInfo(): Flow<List<WeatherDataDb>>
    fun getDaysWeatherInfo(): Flow<List<WeatherDayDetails>>
}