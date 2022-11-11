package com.example.weather_forecast.data.mappers

import com.example.weather_forecast.data.local.database.model.WeatherDataDb
import com.example.weather_forecast.data.remote.WeatherDataDto
import com.example.weather_forecast.data.remote.WeatherDto
import com.example.weather_forecast.domain.model.WeatherDayDetails
import com.example.weather_forecast.domain.model.WeatherDetails
import com.example.weather_forecast.domain.model.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun WeatherDataDto.toWeatherDataList(): List<WeatherDataDb> {
    return List(time.size) { index ->
        val time = time[index]
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        WeatherDataDb(
            time,
            temperature,
            pressure,
            windSpeed,
            humidity,
            weatherCode
        )
    }
}

fun WeatherDto.toWeatherDataList(): List<WeatherDataDb> {
    return weatherData.toWeatherDataList()
}

fun List<WeatherDetails>.toWeatherDetailsGroups(): List<WeatherDayDetails> {
    return groupBy { it.time.dayOfMonth }.values.map {
        WeatherDayDetails(
            time = it.first().time,
            maxTemperature = it.maxOf { it.temperature },
            minTemperature = it.minOf { it.temperature },
            weatherType = it.first { it.time.hour == LocalDateTime.now().hour }.weatherType
        )
    }
}

fun WeatherDataDb.toWeatherDetails(): WeatherDetails {
    return WeatherDetails(
        time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
        temperature = temperature,
        pressure = pressure,
        windSpeed = windSpeed,
        humidity = humidity,
        weatherType = WeatherType.fromWMO(weatherCode)
    )
}
