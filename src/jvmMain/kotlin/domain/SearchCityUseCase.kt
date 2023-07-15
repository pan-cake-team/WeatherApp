package domain

import data.repository.WeatherRepository
import domain.model.WeatherModel

class SearchCityUseCase(
    private val weatherRepository: WeatherRepository,
) {

    suspend operator fun invoke(city: String) = searchCity(city)

    private suspend fun searchCity(city: String): WeatherModel {
        return weatherRepository.searchForecastDay(city).toWeatherModel()
    }
}