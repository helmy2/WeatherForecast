package com.example.weather_forecast.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_forecast.domain.location.LocationTracker
import com.example.weather_forecast.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {
    val currentWeatherData = repository.getCurrentWeatherInfo().stateIn(
        scope = viewModelScope,
        initialValue = null,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000)
    )

    fun updateWeatherData() {
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                repository.updateData(location.latitude, location.longitude)
            }
        }
    }
}