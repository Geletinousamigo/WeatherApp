package com.nikhil.weatherapp.data.repository

import com.nikhil.weatherapp.data.mappers.toWeatherInfo
import com.nikhil.weatherapp.data.remote.WeatherApi
import com.nikhil.weatherapp.domain.repository.WeatherRepository
import com.nikhil.weatherapp.domain.util.Resource
import com.nikhil.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {

            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )

        }catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message?: "An Unknown Error Occurred.")
        }
    }
}