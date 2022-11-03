package com.example.weather_forecast.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_forecast.domain.model.WeatherInfo
import com.example.weather_forecast.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: WeatherRepository
) : ViewModel() {
    val currentWeatherData: StateFlow<WeatherInfo?> = repository.getWeatherData().stateIn(
        scope = viewModelScope,
        initialValue = null,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000)
    )
}