package com.example.weather_forecast.di

import android.content.Context
import com.example.weather_forecast.data.local.WeatherDao
import com.example.weather_forecast.data.local.WeatherDatabase
import com.example.weather_forecast.data.remote.WeatherApi
import com.example.weather_forecast.data.repository.WeatherRepositoryImpl
import com.example.weather_forecast.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.DelicateCoroutinesApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@DelicateCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun bindWeatherRepository(
        weatherDao: WeatherDao,
        weatherApi: WeatherApi
    ): WeatherRepository = WeatherRepositoryImpl(weatherDao, weatherApi)

    @Singleton
    @Provides
    fun provideWeatherDao(@ApplicationContext context: Context): WeatherDao {
        return WeatherDatabase.getInstance(context).weatherDao()
    }
}

