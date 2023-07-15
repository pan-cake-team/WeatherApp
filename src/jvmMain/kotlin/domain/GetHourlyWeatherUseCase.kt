package domain

import domain.model.HourlyWeather
import data.repository.WeatherRepository
import domain.model.WeatherModel
import ui.screens.DayHourIntervals
//
//class GetHourlyWeatherUseCase(
//    private val weatherRepository: WeatherRepository,
//    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
//) {
//    suspend operator fun invoke() = getHourlyCurrentLocationWeather()
//
//    private suspend fun getHourlyCurrentLocationWeather(): WeatherModel {
//        val currentLocation = getCurrentLocationUseCase()
//        return weatherRepository.getForecasts(currentLocation.loc)
//    }
//}

