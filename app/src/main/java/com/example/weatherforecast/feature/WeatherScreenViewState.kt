package com.example.weatherforecast.feature

import android.health.connect.datatypes.units.Temperature

sealed interface Weather

data class Content(
    val states: List<WeatherScreenViewState>
): Weather {
    data class WeatherScreenViewState(

        val imageUrl: String,
        val maxTemperature: Int,
        val minTemperature: Int,
        val date: String,
        val city: String,

//    val weatherCode: Int,

    )
}

data object LoadingViewState: Weather