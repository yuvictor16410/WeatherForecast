package com.example.weatherforecast.feature


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

        is Content -> {
            WeatherContent(modifier = modifier, states = state.states)
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
    states: List<Content.WeatherScreenViewState>
){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.size(128.dp))

        CurrentWeather(states.first())

        Spacer(modifier = Modifier.size(64.dp))


        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            states.forEach {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WeatherCard(it)
                }
            }
        }
    }
}

@Composable
private fun CardRow(states: List<Content.WeatherScreenViewState>){
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        states.forEach {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherCard(it)
            }
        }
    }
}

@Composable
private fun WeatherCard(state: Content.WeatherScreenViewState){
    Text(
        text = "${state.date}",
        fontSize = 16.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.W900,
        color = Color.White
    )


    AsyncImage(
        modifier = Modifier.size(100.dp),
        model = state.imageUrl,
        contentDescription = null,
    )

    Text(
        text = "${state.minTemperature}°C/${state.maxTemperature}°C",
        fontSize = 16.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.W900,
        color = Color.White
    )
}

@Composable
private fun CurrentWeather(todayState: Content.WeatherScreenViewState){

    // open soucr lib
    //
    AsyncImage(
        modifier = Modifier.size(300.dp),
        model = todayState.imageUrl,
        contentDescription = null,

        )

    Spacer(modifier = Modifier.size(64.dp))

    Text(
        text = "${todayState.minTemperature}°C/${todayState.maxTemperature}°C",
        fontSize = 32.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.W900,
        color = Color.White
    )

    Spacer(modifier = Modifier.size(16.dp))

    Text(
        text = todayState.city,
        fontSize = 24.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.W900,
        color = Color.White
    )
}

@Preview
@Composable
fun WeatherScreenPreview(){
    WeatherContent(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        states = listOf(
            Content.WeatherScreenViewState(
                imageUrl = "http://openweathermap.org/img/wn/03d@2x.png",
                maxTemperature = 20,
                minTemperature = 10,
                date = "12/07/2026",
                city = "Wellington"
            ),

            Content.WeatherScreenViewState(
                imageUrl = "http://openweathermap.org/img/wn/03d@2x.png",
                maxTemperature = 20,
                minTemperature = 10,
                date = "12/07/2026",
                city = "Wellington"
            ),

            Content.WeatherScreenViewState(
                imageUrl = "http://openweathermap.org/img/wn/03d@2x.png",
                maxTemperature = 20,
                minTemperature = 10,
                date = "12/07/2026",
                city = "Wellington"
            )
        )

    )
}


// Example of dependency injection without hilt
class Car(val engine: Engine){
    fun StartCar(){
        engine.startEngine()
        println("Car Started")
    }
}

fun main(){
    val engine = Engine()
    val car = Car(engine)
    car.StartCar()
}

class Engine(){
    fun startEngine(){
        println("Engine Started")
    }
}