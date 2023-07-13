package data.repository

import data.remote.WeatherService
import domain.model.DailyWeather
import domain.model.HourlyWeather
import data.remote.dto.Location
import data.remote.response.mapper.toDailyWeather
import data.remote.response.mapper.toHourlyWeather

class WeatherRepositoryImp(private val weatherService: WeatherService) : WeatherRepository {


    override suspend fun getDailyWeather(lat: Double, lon: Double): List<DailyWeather> {
        return weatherService.getDailyWeather(lat, lon).toDailyWeather()
    }

    override suspend fun getHourWeather(lat: Double, lon: Double): List<HourlyWeather> {
        return weatherService.getHourWeather(lat,lon).toHourlyWeather()
    }

    override suspend fun getCurrentLocation(): Location {
        return weatherService.getLocation()
    }
}