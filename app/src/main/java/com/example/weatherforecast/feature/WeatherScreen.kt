package com.example.weatherforecast.feature


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import coil3.compose.AsyncImage
import com.example.weatherforecast.R

@Composable
fun WeatherScreen(
    modifier: Modifier,
    viewModel: WeatherScreenViewModel = hiltViewModel()
){
    when(val state = viewModel.viewState.value){
        is LoadingViewState -> LoadingScreen(modifier = Modifier)

        is WeatherScreenViewState -> {
            WeatherContent(modifier = modifier, state = state)
        }
    }

}

@Composable
private fun LoadingScreen(
    modifier: Modifier,

){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        CircularProgressIndicator(
            color = Color.White,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier.size(16.dp))
        Text(
            text = "Loading...",
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W900,
            color = Color.White
        )

    }
}

@Composable
fun WeatherContent(
    modifier: Modifier,
    state: WeatherScreenViewState
){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.size(128.dp))


        AsyncImage(
            modifier = Modifier.size(300.dp),
            model = state.imageUrl,
            contentDescription = null,

        )


//        Image(
//            painter = painterResource(R.drawable.sun),
//            contentDescription = null
//        )

        Spacer(modifier = Modifier.size(64.dp))

        Text(
            text = "${state.minTemperature}°C/${state.maxTemperature}°C",
            fontSize = 32.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W900,
            color = Color.White
        )

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = state.city,
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W900,
            color = Color.White
        )





    }
}

@Preview
@Composable
fun WeatherScreenPreview(){
    WeatherContent(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        state = WeatherScreenViewState(
            imageUrl = "http://openweathermap.org/img/wn/03d@2x.png",
            maxTemperature = 20,
            minTemperature = 10,
            city = "Wellington"
        )
    )
}