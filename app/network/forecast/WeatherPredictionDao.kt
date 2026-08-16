package com.example.weatherforecast.network.forecast

import com.example.weatherforecast.network.forecast.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherPredictionDao {

    @GET("/v1/forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily: String,
//        @Query("hourly") hourly: String,
//        @Query("current") current: String,
        @Query("timezone") timezone: String,
        @Query("forecast_days") forecastDays: Int
    ): WeatherResponseDto

}