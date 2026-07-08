package com.example.weatherforecast.feature

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class WeatherScreenViewModel @Inject constructor(
    repo: Repository
): ViewModel() {

    var viewState: MutableState<Weather> = mutableStateOf(LoadingViewState)

    init{
        viewModelScope.launch {
            viewState.value = repo.getWeather(41.2866, 174.7756)

        }
    }
}