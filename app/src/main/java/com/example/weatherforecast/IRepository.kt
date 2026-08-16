package com.example.weatherforecast

import com.example.weatherforecast.feature.Content
import com.example.weatherforecast.model.City

interface IRepository {
    suspend fun getWeather(city: City): Content
}