package com.nikhil.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nikhil.weatherapp.domain.weather.WeatherData
import com.nikhil.weatherapp.presentation.ui.theme.DeepBlue
import java.time.format.DateTimeFormatter

@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier= Modifier,
    textColor: Color = Color.White
) {
    val formattedTime = remember(weatherData){
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }
    Card(
        elevation = 2.dp,
        backgroundColor = DeepBlue,
        modifier = modifier
    ) {
        Column(
            modifier = modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = formattedTime,
                color = Color.LightGray
            )
            Image(
                painter = painterResource(id = weatherData.weatherType.iconRes),
                contentDescription = weatherData.weatherType.weatherDesc,
                modifier = Modifier.width(40.dp)
            )
            Text(
                text = "${weatherData.temperatureCelsius}°C",
                color = textColor,
                fontWeight = FontWeight.Bold
            )

        }
    }
}