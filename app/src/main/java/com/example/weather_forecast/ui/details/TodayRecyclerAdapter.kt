package com.example.weather_forecast.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_forecast.databinding.CustomeHourItemBinding
import com.example.weather_forecast.domain.model.WeatherDetails

class TodayRecyclerAdapter(private val data: List<WeatherDetails>) :
    RecyclerView.Adapter<TodayRecyclerAdapter.TodayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        val listOfDay =
            CustomeHourItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodayViewHolder(listOfDay)
    }

    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class TodayViewHolder(val binding: CustomeHourItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WeatherDetails) {
            binding.itemHour = item
        }

    }
}