package domain


import data.remote.dto.WeatherForecastDto
import data.repository.WeatherRepository
import domain.mapper.toDaysForcast
import domain.model.WeatherModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class GetWeatherUseCase: KoinComponent {

    private val weatherRepository: WeatherRepository by inject()
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase by inject()

    suspend operator fun invoke() = getDailyCurrentLocationWeather()


    private suspend fun getDailyCurrentLocationWeather(): WeatherModel {
        val currentLocation = getCurrentLocationUseCase()
        return weatherRepository.getForecasts(currentLocation.loc).toWeatherModel()
    }
}

fun WeatherForecastDto.toWeatherModel(): WeatherModel {
    return WeatherModel(
        location = this.location?.let { it.country + "," + it.name },
        data = this.forecast?.forecastday?.map { it.toDaysForcast() },
    )
}



