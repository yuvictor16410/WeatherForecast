package com.example.weatherforecast

import com.example.weatherforecast.network.forecast.WeatherPredictionDao
import com.example.weatherforecast.network.image.WeatherImageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class WeatherModule {
    @Provides
    @Singleton
    fun provideRepository(
        predictionDao: WeatherPredictionDao,
        imageDao: WeatherImageDao,
    ): IRepository {
        return Repository(
            forecastDao = predictionDao,
            imageDao = imageDao,
        )
    }
}