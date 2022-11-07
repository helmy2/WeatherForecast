package com.example.weather_forecast.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.weather_forecast.databinding.FragmentDetailsBinding
import com.example.weather_forecast.domain.model.WeatherDetails
import com.example.weather_forecast.domain.model.WeatherType
import java.time.LocalDateTime

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    private val listToDay = listOf(
        WeatherDetails(
            LocalDateTime.now(),
            25.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(2)
        ),
        WeatherDetails(
            LocalDateTime.now(),
            55.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(45)
        ),
        WeatherDetails(
            LocalDateTime.now(),
            25.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(55)
        ),
        WeatherDetails(
            LocalDateTime.now(),
            25.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(77)
        )
    )
    private val listForcast = listOf(
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(2)
        ),
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(5)
        ),
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(55)
        ),
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(77)
        ),
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(45)
        ),
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(2)
        ),
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todayAdapter = TodayRecyclerAdapter(listToDay)
        val forecastAdapter = ForecastRecyclerAdapter(listForcast)

        binding.dateItem = listToDay.first()
        binding.recyclerViewToday.adapter = todayAdapter
        binding.recyclerViewNextForecast.adapter = forecastAdapter

    }
}