package data.repository

import data.remote.dto.CurrentLocation
import data.remote.dto.WeatherForecastDto

interface WeatherRepository  {
    suspend fun getCurrentLocation(): CurrentLocation

    suspend fun getForecasts(latLongLocation: String) : WeatherForecastDto

    suspend fun searchForecastDay(city: String): WeatherForecastDto
}