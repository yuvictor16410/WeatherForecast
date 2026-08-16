package com.example.weatherforecast.model

data class City(
    val name: String,
    val latitude: Double,
    val longitude: Double,
)

object Cities{
    val wellington = City(
        name = "Wellington",
        latitude = -41.2866,
        longitude = 174.7756,
    )

}