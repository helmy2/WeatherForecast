package com.example.weather_forecast.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.weather_forecast.R
import com.example.weather_forecast.databinding.FragmentDetailsBinding
import com.example.weather_forecast.domain.model.WeatherDetails
import com.example.weather_forecast.domain.model.WeatherType
import java.time.LocalDateTime


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit  var manager:RecyclerView.LayoutManager

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
            WeatherType.fromWMO(5)
        ),
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(5)
        ),
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(5)
        ),
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(5)
        ),
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(5)
        ),
        WeatherDetails(
            LocalDateTime.now(), 25.0, 1015.2, 10.0, 90.0,
            WeatherType.fromWMO(5)
        ),
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val todayAdapter=TodayRecyclerAdapter(listToDay)
        binding.recyclerViewToday.adapter=todayAdapter

        manager=LinearLayoutManager(context)
        binding.recyclerViewToday.apply {
            adapter=todayAdapter
            LayoutManager=manager
        }
    }


}