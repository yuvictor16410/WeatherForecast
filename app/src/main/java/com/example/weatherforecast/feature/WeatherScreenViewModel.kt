package com.example.weatherforecast.feature

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.IRepository
import com.example.weatherforecast.model.Cities
import com.example.weatherforecast.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class WeatherScreenViewModel @Inject constructor(
    repo: IRepository
): ViewModel() {

    var viewState: MutableState<Weather> = mutableStateOf(LoadingViewState)

    init{
        viewModelScope.launch {
            viewState.value = repo.getWeather(city = Cities.wellington)

        }
    }
}