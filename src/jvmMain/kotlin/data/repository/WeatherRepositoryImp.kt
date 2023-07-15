package data.repository

import data.remote.WeatherService
import data.remote.dto.CurrentLocation
import data.remote.dto.WeatherForecastDto
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class WeatherRepositoryImp() :KoinComponent, WeatherRepository {

    private val weatherService: WeatherService by inject()


    override suspend fun getCurrentLocation(): CurrentLocation {
        return weatherService.getLocation()
    }

    override suspend fun getForecasts(latLongLocation: String): WeatherForecastDto {
        return weatherService.getForecast(latLongLocation)
    }

    override suspend fun searchForecastDay(city: String): WeatherForecastDto {
        return weatherService.searchForecast(city)
    }


}