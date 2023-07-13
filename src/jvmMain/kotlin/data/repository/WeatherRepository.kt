package data.repository

import domain.model.DailyWeather
import domain.model.HourlyWeather
import data.remote.dto.Location

interface WeatherRepository  {
    suspend fun getCurrentLocation(): Location
    suspend fun getDailyWeather(lat:Double,lon:Double): List<DailyWeather>
    suspend fun getHourWeather(lat:Double,lon:Double): List<HourlyWeather>
}