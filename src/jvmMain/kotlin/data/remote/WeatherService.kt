package data.remote

import data.remote.dto.Location
import data.remote.dto.IntervalDTO

interface WeatherService {
    suspend fun getDailyWeather(lat:Double,lon:Double):  List<IntervalDTO>
    suspend fun getHourWeather(lat:Double,lon:Double): List<IntervalDTO>
    suspend fun getLocation(): Location
}