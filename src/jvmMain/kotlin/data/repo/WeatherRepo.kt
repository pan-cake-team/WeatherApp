package data.repo

import data.remote.dto.Location
import data.remote.dto.WeatherResponse

interface WeatherRepo {

    suspend fun getDailyWeather(): List<WeatherResponse>
    suspend fun getHourlyWeather(): List<WeatherResponse>

    suspend fun getCurrentLocation(): Location


}