package data.remote

import data.remote.dto.Location
import data.remote.dto.WeatherResponse

interface WeatherService {
    suspend fun getDailyWeather(): WeatherResponse
    suspend fun getHourWeather(): WeatherResponse

    suspend fun getLocation(): Location
}