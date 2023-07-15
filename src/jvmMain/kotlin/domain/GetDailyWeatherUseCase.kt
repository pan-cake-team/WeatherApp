package domain

import domain.model.DailyWeather
import data.repository.WeatherRepository
import domain.model.Forecast
import domain.model.WeatherModel
import ui.screens.DaysInterval


class GetDailyWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
) {
    suspend operator fun invoke() = getDailyCurrentLocationWeather()


    private suspend fun getDailyCurrentLocationWeather(): WeatherModel {
        val currentLocation = getCurrentLocationUseCase()
        return weatherRepository.getForecasts(currentLocation.loc)
    }
}
