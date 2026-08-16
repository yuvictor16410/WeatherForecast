package com.example.weatherforecast.network.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponseDto(

    @SerialName("daily") val daily: Daily,



    ){
    @Serializable
    data class Daily(
        @SerialName("time") val time: List<String>,
        @SerialName("temperature_2m_max") val maxTemperature: List<Double>,
        @SerialName("temperature_2m_min") val minTemperature: List<Double>,
        @SerialName("weather_code") val weatherCode: List<Int>,
//        @SerialName("uv_index_max") val maxUvIndex: List<Double>,
//        @SerialName("sunset") val sunset: List<Text>,
//        @SerialName("sunrise") val sunrise: List<Text>
    )
}