package data.repo

import data.remote.WeatherService
import data.remote.dto.WeatherResponse

class WeatherRepoImpl(
    weatherService: WeatherService,
) : WeatherRepo{

    override suspend fun getDailyWeather(): List<WeatherResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getHourlyWeather(): List<WeatherResponse> {
        TODO("Not yet implemented")
    }

}