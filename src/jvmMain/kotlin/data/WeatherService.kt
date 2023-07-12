package data

import data.dto.Response

interface WeatherService {
    suspend fun getDailyWeather(): Response
    suspend fun getHourWeather(): Response
}