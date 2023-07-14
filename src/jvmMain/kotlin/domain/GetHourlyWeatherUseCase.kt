package domain

import domain.model.HourlyWeather
import data.repository.WeatherRepository
import ui.screens.DayHourIntervals

class GetHourlyWeatherUseCase(
    private val hourlyWeather: WeatherRepository,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
) {
    suspend operator fun invoke() = getHourlyCurrentLocationWeather()

    private suspend fun getHourlyCurrentLocationWeather(): List<DayHourIntervals> {
        val currentLocation = getCurrentLocationUseCase()
        return hourlyWeather.getHourWeather(currentLocation.lat, currentLocation.long).toDayHourIntervals()
    }
}

private fun List<HourlyWeather>.toDayHourIntervals(): List<DayHourIntervals> {

    return this.map { hourlyInterval ->
        DayHourIntervals(
            hour = hourlyInterval.date,
            weatherType = hourlyInterval.weatherCode.toString(),
            temp = hourlyInterval.temperature.toInt(),
        )
    }
}

