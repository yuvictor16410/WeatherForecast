package com.example.weatherforecast

import com.example.weatherforecast.network.forecast.WeatherPredictionDao
import com.example.weatherforecast.network.Repository
import com.example.weatherforecast.network.image.WeatherImageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(): WeatherPredictionDao{

        val json = Json { ignoreUnknownKeys = true }

        return Retrofit
            .Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl("https://api.open-meteo.com")
            .build()
            .create(WeatherPredictionDao::class.java)


    }

    @Provides
    @Singleton
    fun provideImageDao(): WeatherImageDao{

        val json = Json { ignoreUnknownKeys = true }

        return Retrofit
            .Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl("https://gist.githubusercontent.com/")
            .build()
            .create(WeatherImageDao::class.java)


    }

    @Provides
    @Singleton
    fun provideRepository(
        predictionDao: WeatherPredictionDao,
        imageDao: WeatherImageDao,
    ): Repository {
        return Repository(
            forecastDao = predictionDao,
            imageDao = imageDao,
        )
    }


}