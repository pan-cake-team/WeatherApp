package domain

import data.remote.dto.CurrentLocation
import data.repository.WeatherRepository

class GetCurrentLocationUseCase(
    private val location: WeatherRepository
) {
    suspend operator fun invoke(): CurrentLocation {
        return location.getCurrentLocation()
    }

}