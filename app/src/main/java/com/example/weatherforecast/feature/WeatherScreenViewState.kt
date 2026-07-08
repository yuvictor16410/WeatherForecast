package com.example.weatherforecast.feature

import android.health.connect.datatypes.units.Temperature

sealed interface Weather
data class WeatherScreenViewState(

    val imageUrl: String,
    val maxTemperature: Int,
    val minTemperature: Int,
    val city: String,

//    val weatherCode: Int,

): Weather

data object LoadingViewState: Weather