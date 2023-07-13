package data

import data.dto.WeatherResponse

interface WeatherService {
    suspend fun getDailyWeather(): WeatherResponse
    suspend fun getHourWeather(): WeatherResponse
}