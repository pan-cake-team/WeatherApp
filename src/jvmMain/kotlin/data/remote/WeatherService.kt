package data.remote

import data.remote.dto.IntervalDTO
import data.remote.response.WeatherResponse

interface WeatherService {
    suspend fun getDailyWeather(lat:Double,lon:Double):  List<IntervalDTO>
    suspend fun getHourWeather(lat:Double,lon:Double): List<IntervalDTO>
}