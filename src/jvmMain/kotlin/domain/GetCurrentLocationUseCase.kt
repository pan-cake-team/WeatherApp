package domain

import data.remote.dto.Location
import data.repository.WeatherRepository

class GetCurrentLocationUseCase(
    private val weatherRepo: WeatherRepository
) {

    suspend operator fun invoke(): Location {
        return weatherRepo.getCurrentLocation()
    }


}