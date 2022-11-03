package com.example.weather_forecast.data.repository

import com.example.weather_forecast.data.mappers.toWeatherInfo
import com.example.weather_forecast.data.remote.WeatherApi
import com.example.weather_forecast.domain.model.WeatherInfo
import com.example.weather_forecast.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl(
    private val api: WeatherApi
) : WeatherRepository {

    override fun getWeatherData(): Flow<WeatherInfo> {
        return flow {
            try {
                val data = api.getWeatherData(
                    lat = 30.521369931774057,
                    long = 31.232200496284516
                ).toWeatherInfo()
                emit(data)
            } catch (_: Exception) {

            }
        }
    }
}