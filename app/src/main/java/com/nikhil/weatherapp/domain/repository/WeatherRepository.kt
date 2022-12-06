package com.nikhil.weatherapp.domain.repository

import com.nikhil.weatherapp.domain.util.Resource
import com.nikhil.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>

}