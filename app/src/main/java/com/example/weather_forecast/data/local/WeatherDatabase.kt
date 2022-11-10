package com.example.weather_forecast.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weather_forecast.data.local.model.WeatherDataDb
import kotlinx.coroutines.DelicateCoroutinesApi

@Database(
    entities = [
        WeatherDataDb::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    @DelicateCoroutinesApi
    companion object {
        private const val Weather_DB_NAME = "weather-db"

        @Volatile
        private var INSTANCE: WeatherDatabase? = null

        fun getInstance(context: Context): WeatherDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): WeatherDatabase {
            val db = Room.databaseBuilder(
                context,
                WeatherDatabase::class.java,
                Weather_DB_NAME
            ).fallbackToDestructiveMigration()

            return db.build()
        }
    }
}
