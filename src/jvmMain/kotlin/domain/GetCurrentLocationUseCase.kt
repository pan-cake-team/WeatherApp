package domain

import data.repository.WeatherRepository
import domain.model.LatLongLocation

class GetCurrentLocationUseCase(
    private val location: WeatherRepository
) {
    suspend operator fun invoke(): LatLongLocation {
        val loc = location.getCurrentLocation()
            .loc.split(",")
            .map { it.toDouble() }

        val (lat, long) = loc
        return LatLongLocation(lat, long)
    }
}