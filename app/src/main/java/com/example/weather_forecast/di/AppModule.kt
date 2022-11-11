package com.example.weather_forecast.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.weather_forecast.data.local.database.WeatherDao
import com.example.weather_forecast.data.local.database.WeatherDatabase
import com.example.weather_forecast.data.local.location.LocationTrackerImpl
import com.example.weather_forecast.data.remote.WeatherApi
import com.example.weather_forecast.data.repository.WeatherRepositoryImpl
import com.example.weather_forecast.domain.location.LocationTracker
import com.example.weather_forecast.domain.repository.WeatherRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
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
        weatherApi: WeatherApi,
    ): WeatherRepository = WeatherRepositoryImpl(weatherDao, weatherApi)

    @Singleton
    @Provides
    fun provideWeatherDao(@ApplicationContext context: Context): WeatherDao {
        return WeatherDatabase.getInstance(context).weatherDao()
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }

    @Provides
    @Singleton
    fun provideLocationTracker(
        locationClient: FusedLocationProviderClient,
        application: Application,
    ): LocationTracker =
        LocationTrackerImpl(locationClient, application)

}

