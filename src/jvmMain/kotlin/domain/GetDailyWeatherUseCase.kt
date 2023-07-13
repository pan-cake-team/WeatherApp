package domain

import data.domain.entity.DailyWeather
import data.remote.WeatherService
import data.remote.dto.IntervalDTO
import data.remote.dto.Location
import data.repository.WeatherRepository


class GetDailyWeatherUseCase(
    private val dailyWeatherResponse: WeatherRepository
) {
    suspend operator fun invoke(lat: Double, lon: Double): List<DailyWeather> {
        return dailyWeatherResponse.getDailyWeather(lat, lon)
    }
}