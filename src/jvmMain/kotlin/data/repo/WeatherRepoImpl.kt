package data.repo

import data.remote.WeatherService
import data.remote.dto.Location
import data.remote.response.WeatherResponse

class WeatherRepoImpl(
    private val weatherService: WeatherService,
) : WeatherRepo{

    override suspend fun getDailyWeather(): List<WeatherResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getHourlyWeather(): List<WeatherResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentLocation(): Location {
        return weatherService.getLocation()
    }
}