package com.example.weatherforecast.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.w3c.dom.Text

@Serializable
data class WeatherResponseDto(

    @SerialName("daily") val daily: Daily,
    @SerialName("daily_units") val dailyUnits: DailyUnits



){
    @Serializable
    data class Daily(
        @SerialName("time") val time: Text,
        @SerialName("weather_code") val weather_code: Int,
        @SerialName("temperature_2m_max") val maxTemperature: Double,
        @SerialName("temperature_2m_min") val minTemperature: Double,
        @SerialName("uv_index_max") val maxUvIndex: Double,
        @SerialName("sunset") val sunset: Text,
        @SerialName("sunrise") val sunrise: Text
    )

    @Serializable
    data class DailyUnits(
        @SerialName("time") val timeUnits: Text,
        @SerialName("weather_code") val weatherCodeUnits: Text,
        @SerialName("temperature_2m_max") val maxTemperatureUnits: Text,
        @SerialName("temperature_2m_min") val minTemperatureUnits: Text,
        @SerialName("uv_index_man") val maxUvIndexUnits: Text,
        @SerialName("sunset") val sunsetUnits: Text,
        @SerialName("sunrise") val sunriseUnits: Text,


    )
}