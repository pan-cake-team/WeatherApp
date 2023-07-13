package domain

import data.remote.dto.Location
import data.repository.WeatherRepository

class GetCurrentLocationUseCase(
    private val location: WeatherRepository
) {
    suspend operator fun invoke(): Location {
        return location.getCurrentLocation()
    }
}