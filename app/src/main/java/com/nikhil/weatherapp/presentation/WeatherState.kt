package com.nikhil.weatherapp.presentation

import com.nikhil.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo?=null,
    val isLoading: Boolean =false,
    val error: String? = null
)
