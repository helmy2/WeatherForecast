package com.example.weather_forecast.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_forecast.databinding.CustomeDayItemBinding
import com.example.weather_forecast.domain.model.WeatherDetails

class ForecastRecyclerAdapter(private val data2:List<WeatherDetails>):RecyclerView.Adapter<ForecastRecyclerAdapter.ForecastViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val listOfForecastData = CustomeDayItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ForecastViewHolder(listOfForecastData)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(data2[position])
    }

    override fun getItemCount(): Int {
        return data2.size
    }

    class ForecastViewHolder(val binding:CustomeDayItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:WeatherDetails){
            binding.itemDay=item

        }
    }
}