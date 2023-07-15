package domain

import data.repository.WeatherRepository
import domain.model.WeatherModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchCityUseCase: KoinComponent{

    private val weatherRepository: WeatherRepository by inject()

    suspend operator fun invoke(city: String) = searchCity(city)

    private suspend fun searchCity(city: String): WeatherModel {
        return weatherRepository.searchForecastDay(city).toWeatherModel()
    }
}