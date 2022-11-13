package com.example.weather_forecast.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_forecast.databinding.CustomeHourItemBinding
import com.example.weather_forecast.domain.model.WeatherDetails

class TodayRecyclerAdapter : ListAdapter<WeatherDetails, TodayViewHolder>(DayDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        return TodayViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DayDiffCallBack : DiffUtil.ItemCallback<WeatherDetails>() {
    override fun areItemsTheSame(oldItem: WeatherDetails, newItem: WeatherDetails): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeatherDetails, newItem: WeatherDetails): Boolean {
        return oldItem == newItem
    }
}

class TodayViewHolder(val binding: CustomeHourItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WeatherDetails) {
        binding.itemHour = item
    }

    companion object {
        fun from(parent: ViewGroup): TodayViewHolder {
            val binding =
                CustomeHourItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TodayViewHolder(binding)
        }
    }

}