package domain

import data.repository.WeatherRepository

class GetCityLocationUseCase(
    private val searchCity: WeatherRepository
){

}