package domain

import domain.model.DailyWeather
import data.repository.WeatherRepository
import ui.screens.DaysInterval


class GetDailyWeatherUseCase(
    private val dailyWeatherResponse: WeatherRepository,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
) {
    suspend operator fun invoke() = getDailyCurrentLocationWeather()

    private suspend fun getDailyCurrentLocationWeather(): List<DaysInterval>{
        val currentLocation = getCurrentLocationUseCase()
        return dailyWeatherResponse.getDailyWeather(currentLocation.lat, currentLocation.long).toDaysInterval()
    }
}

private fun List<DailyWeather>.toDaysInterval(): List<DaysInterval> {
    return this.map { dailyWeathers ->
        DaysInterval(
            day = dailyWeathers.date,
            minTemp = dailyWeathers.temperatureMin.toInt(),
            maxTemp = dailyWeathers.temperature.toInt(),
            weatherType = dailyWeathers.weatherCode.toString(),
            windGust = dailyWeathers.windGust,
            windSpeed = dailyWeathers.windSpeed,
        )
    }
}