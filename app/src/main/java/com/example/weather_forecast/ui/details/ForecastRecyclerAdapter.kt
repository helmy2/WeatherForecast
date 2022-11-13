package com.example.weather_forecast.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_forecast.databinding.CustomeDayItemBinding
import com.example.weather_forecast.domain.model.WeatherDetails

class ForecastRecyclerAdapter :
    ListAdapter<WeatherDetails, ForecastViewHolder>(WeatherDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}

class WeatherDiffCallBack : DiffUtil.ItemCallback<WeatherDetails>() {
    override fun areItemsTheSame(oldItem: WeatherDetails, newItem: WeatherDetails): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeatherDetails, newItem: WeatherDetails): Boolean {
        return oldItem == newItem
    }

}

class ForecastViewHolder(val binding: CustomeDayItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WeatherDetails) {
        binding.itemDay = item
    }

    companion object {
        fun from(parent: ViewGroup): ForecastViewHolder {
            val binding =
                CustomeDayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ForecastViewHolder(binding)
        }
    }
}