package domain

import domain.model.DailyWeather
import data.repository.WeatherRepository
import domain.model.Forecast
import ui.screens.DaysInterval


//class GetDailyWeatherUseCase(
//    private val dailyWeatherResponse: WeatherRepository,
//    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
//) {
//    suspend operator fun invoke() = getDailyCurrentLocationWeather()
//
//    private suspend fun getDailyCurrentLocationWeather(): List<Forecast>{
//        val currentLocation = getCurrentLocationUseCase()
//        return dailyWeatherResponse.getDailyWeather(currentLocation.lat, currentLocation.long).toDaysInterval()
//    }
//}
