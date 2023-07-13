package data.repository

import data.domain.entity.DailyWeather
import data.domain.entity.HourlyWeather
import data.remote.dto.Location

interface WeatherRepository  {
    suspend fun getCurrentLocation(): Location
    suspend fun getDailyWeather(lat:Double,lon:Double): List<DailyWeather>
    suspend fun getHourWeather(lat:Double,lon:Double): List<HourlyWeather>
}