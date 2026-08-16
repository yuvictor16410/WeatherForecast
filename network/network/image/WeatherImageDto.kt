package com.example.weatherforecast.network.image

import com.example.weatherforecast.network.forecast.WeatherResponseDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WeatherImageDto(

    @SerialName("day")
    val day: DayImageDto,
){
    @Serializable
    data class DayImageDto(
        @SerialName("description")
        val description: String,

        @SerialName("image")
        val image: String,

    )
}