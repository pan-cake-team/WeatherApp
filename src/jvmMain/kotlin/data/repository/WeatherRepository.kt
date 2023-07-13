package data.repository

import data.domain.entity.DailyWeather
import data.domain.entity.HourlyWeather

interface WeatherRepository  {

    suspend fun getDailyWeather(lat:Double,lon:Double): List<DailyWeather>
    suspend fun getHourWeather(lat:Double,lon:Double): List<HourlyWeather>
}