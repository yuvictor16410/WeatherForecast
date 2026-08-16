package com.example.weatherforecast.network

import com.example.weatherforecast.feature.Content
import com.example.weatherforecast.feature.Weather
import com.example.weatherforecast.feature.Content.WeatherScreenViewState
import com.example.weatherforecast.model.City
import com.example.weatherforecast.network.forecast.WeatherPredictionDao
import com.example.weatherforecast.network.forecast.WeatherResponseDto
import com.example.weatherforecast.network.image.WeatherImageDao
import com.example.weatherforecast.network.image.WeatherImageDto
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.roundToInt

@Singleton
class Repository @Inject constructor(
    private val forecastDao: WeatherPredictionDao,
    private val imageDao: WeatherImageDao,
){

    suspend fun getWeather(city: City): Content {
        val weather: WeatherResponseDto = forecastDao.getWeather(
            latitude = city.latitude,
            longitude = city.longitude,
            daily = DAILY,
            timezone = TIMEZONE,
            forecastDays = FORECAST_DAYS,

        )

        val imageMap = getImage()

        val states = weather.daily.weatherCode.mapIndexed { index, item ->
            val imageDto: WeatherImageDto = imageMap.getValue(item.toString())
            Content.WeatherScreenViewState(
                imageUrl = imageDto.day.image.replace("http","https"),
                maxTemperature = weather.daily.maxTemperature[index].roundToInt(),
                minTemperature = weather.daily.minTemperature[index].roundToInt(),
                date = weather.daily.time[index],
                city = city.name
            )
        }

        return Content(states = states)
    }

    suspend fun getImage(): Map<String, WeatherImageDto> {
        val imageMap: Map<String, WeatherImageDto> =
            imageDao.getImage("9490c195ed2b53c707087c8c2db4ec0c")
        return imageMap
    }

    companion object{
        private const val DAILY = "weather_code,temperature_2m_max,temperature_2m_min,uv_index_max,sunset,sunrise"

        private const val TIMEZONE = "auto"

        private const val FORECAST_DAYS = 3


    }

}