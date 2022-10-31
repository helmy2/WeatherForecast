package com.example.weather_forecast.domain.model

import java.time.LocalDateTime

data class WeatherDetails(
    val time: LocalDateTime,
    val temperature: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)
