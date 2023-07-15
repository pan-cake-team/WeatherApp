package data.repository

import domain.model.DailyWeather
import domain.model.HourlyWeather
import data.remote.dto.CurrentLocation
import data.remote.dto.WeatherForecastDto
import domain.model.Forecast

interface WeatherRepository  {
    suspend fun getCurrentLocation(): CurrentLocation
    suspend fun getDailyWeather(lat:Double,lon:Double): List<DailyWeather>
    suspend fun getHourWeather(lat:Double,lon:Double): List<HourlyWeather>
    suspend fun getForecastDay() : WeatherForecastDto

    suspend fun searchForecastDay(city: String): List<Forecast>
}