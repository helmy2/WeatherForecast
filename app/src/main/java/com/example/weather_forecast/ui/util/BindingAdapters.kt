package com.example.weather_forecast.ui.util

import android.annotation.SuppressLint
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


@BindingAdapter("today_date_template")
fun TextView.bindToadyDataText(time: LocalDateTime?) {
    time?.let {
        text = time.format(DateTimeFormatter.ofPattern("MMM , d"))
    }
}
    @BindingAdapter("today_time_template")
fun TextView.bindToadyTimeText(time: LocalDateTime?) {
    time?.let {
        text =  time.format(DateTimeFormatter.ofPattern("H:m a"))
    }
}
    @BindingAdapter("forecast_date_template")
fun TextView.bindForecastDataText(time: LocalDateTime?) {
    time?.let {
        text =  time.format(DateTimeFormatter.ofPattern("MMM , d"))
    }
}