package domain

import domain.model.HourlyWeather
import data.repository.WeatherRepository

class GetHourlyWeatherUseCase(
    private val hourlyWeather: WeatherRepository
) {
    suspend operator fun invoke(lat: Double, lon: Double): List<HourlyWeather> {
        return hourlyWeather.getHourWeather(lat, lon)
    }
}