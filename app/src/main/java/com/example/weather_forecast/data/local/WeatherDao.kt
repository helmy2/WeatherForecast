package com.example.weather_forecast.data.local

import androidx.room.*
import com.example.weather_forecast.data.local.model.WeatherDataDb
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM WeatherDataDb")
    fun getAllWeatherData(): Flow<List<WeatherDataDb>>

    @Query("SELECT * FROM WeatherDataDb WHERE time like :todayData")
    fun getTodayWeatherData(todayData: String): Flow<List<WeatherDataDb>>

    @Query("SELECT * FROM WeatherDataDb WHERE time = :time")
    fun getCurrentWeatherData(time: String): Flow<WeatherDataDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherData(vararg data: WeatherDataDb)

}
