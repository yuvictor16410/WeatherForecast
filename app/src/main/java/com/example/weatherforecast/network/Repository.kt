package com.example.weatherforecast.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val apiServiceDao: ApiServiceDao,
){

    suspend fun getWeather(lat: Double, lon: Double){
        val weather = apiServiceDao.getWeather(
            latitude = lat,
            longitude = lon,
            daily = DAILY,
            timezone = TIMEZONE,
            forecastDays = 1,

        )
    }

    companion object{
        private const val DAILY = "weather_code,temperature_2m_max,temperature_2m_min,uv_index_max,sunset,sunrise"

        private const val TIMEZONE = "auto"
    }

}