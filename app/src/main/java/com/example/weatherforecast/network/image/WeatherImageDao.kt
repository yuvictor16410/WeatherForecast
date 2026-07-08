package com.example.weatherforecast.network.image

import com.example.weatherforecast.network.forecast.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherImageDao {

    @GET("/stellasphere/{token}/raw/descriptions.json")
    suspend fun getImage(@Path("token") token: String): Map<String, WeatherImageDto>//not good design for api

}