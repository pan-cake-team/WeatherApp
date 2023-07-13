package domain

import domain.model.HourlyWeather
import data.repository.WeatherRepository
import screens.DayHourIntervals
import screens.HourlyUiState

class GetHourlyWeatherUseCase(
    private val hourlyWeather: WeatherRepository
) {
    suspend operator fun invoke(lat: Double, lon: Double): HourlyUiState {
        return hourlyWeather.getHourWeather(lat, lon).toHourlyUiState()
    }
}

private fun List<HourlyWeather>.toHourlyUiState(): HourlyUiState {

    return HourlyUiState(
        values = this.map { it.toHourlyIntervals() }
    )
}

private fun HourlyWeather.toHourlyIntervals(): DayHourIntervals {
    return DayHourIntervals(
        hour = date,
        temp = temperature.toInt(),
        weatherType = weatherCode.toString(),
    )
}