package com.example.weather_forecast.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherDataDb(
    @PrimaryKey
    val time: String,
    val temperature: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherCode: Int,
)