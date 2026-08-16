package com.example.weatherforecast

import com.example.weatherforecast.network.forecast.WeatherPredictionDao
import com.example.weatherforecast.Repository
import com.example.weatherforecast.network.image.WeatherImageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(): WeatherPredictionDao{
        return getRetrofit("https://api.open-meteo.com").create(WeatherPredictionDao::class.java)


    }

    @Provides
    @Singleton
    fun provideImageDao(): WeatherImageDao{
        return getRetrofit("https://gist.githubusercontent.com/").create(WeatherImageDao::class.java)
    }

    private fun getRetrofit (url: String): Retrofit {

        val json = Json { ignoreUnknownKeys = true }
        return Retrofit
            .Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(url)
            .build()
    }


}