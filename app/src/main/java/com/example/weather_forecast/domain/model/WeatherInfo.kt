package com.example.weather_forecast.domain.model

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherDetails>>,
    val currentWeatherData: WeatherDetails?
)
