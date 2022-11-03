package com.example.weather_forecast.ui.util

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.weather_forecast.domain.model.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@BindingAdapter("weatherType")
fun ImageView.bindWeatherTypeImage(weatherType: WeatherType?) {
    weatherType?.let {
        setImageResource(it.iconRes)
        contentDescription = it.weatherDesc
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("today")
fun TextView.bindDayText(time: LocalDateTime?) {
    time?.let {
        text = "Today, " + time.format(DateTimeFormatter.ofPattern("d MMMM"))
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("weatherTemperature")
fun TextView.bindTemperatureText(temp: Double) {
    text = "${temp.roundToInt()}°C"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("weatherWindSpeed")
fun TextView.bindWindSpeedText(speed: Double) {
    text = "Wind  |  ${speed.roundToInt()} km/h"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("weatherHumidity")
fun TextView.bindHumidityText(hum: Double) {
    text = "Hum  |  ${hum.roundToInt()} %"
}

@BindingAdapter("visible")
fun View.bindVisibleView(isVisible: Boolean?) {
    visibility = if (isVisible == true) View.VISIBLE else View.INVISIBLE
}
