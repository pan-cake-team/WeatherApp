package data.remote

import data.remote.dto.CurrentLocation
import data.remote.dto.WeatherForecastDto

interface WeatherService {
    suspend fun getLocation(): CurrentLocation

    suspend fun getForecast(): WeatherForecastDto
}