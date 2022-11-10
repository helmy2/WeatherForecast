package com.example.weather_forecast.data.repository

import com.example.weather_forecast.data.local.WeatherDao
import com.example.weather_forecast.data.local.model.WeatherDataDb
import com.example.weather_forecast.data.mappers.toWeatherDataList
import com.example.weather_forecast.data.mappers.toWeatherDetails
import com.example.weather_forecast.data.mappers.toWeatherDetailsGroups
import com.example.weather_forecast.data.remote.WeatherApi
import com.example.weather_forecast.domain.model.WeatherDayDetails
import com.example.weather_forecast.domain.model.WeatherDetails
import com.example.weather_forecast.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherRepositoryImpl(
    private val dao: WeatherDao,
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun updateData() {
        val weatherDataDbs =
            api.getWeatherData(lat = 30.521369931774057, long = 31.232200496284516)
                .toWeatherDataList()
        dao.insertWeatherData(data = weatherDataDbs.toTypedArray())
    }

    override fun getWeatherData(): Flow<List<WeatherDetails>> {
        return dao.getAllWeatherData().map {
            it.map { it.toWeatherDetails() }
        }
    }

    override fun getCurrentWeatherInfo(): Flow<WeatherDetails> {
        val time = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:00"))

        return dao.getCurrentWeatherData(time).map {
            it.toWeatherDetails()
        }
    }

    override fun getTodayWeatherInfo(): Flow<List<WeatherDataDb>> {
        val todayData = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'%"))

        return dao.getTodayWeatherData(todayData)
    }


    override fun getDaysWeatherInfo(): Flow<List<WeatherDayDetails>> {
        return getWeatherData().map { it.toWeatherDetailsGroups() }
    }
}