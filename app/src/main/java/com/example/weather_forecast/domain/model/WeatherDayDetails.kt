package com.example.weather_forecast.domain.model

import java.time.LocalDateTime

data class WeatherDayDetails(
    val time: LocalDateTime,
    val maxTemperature: Double,
    val minTemperature: Double,
    val weatherType: WeatherType
)
