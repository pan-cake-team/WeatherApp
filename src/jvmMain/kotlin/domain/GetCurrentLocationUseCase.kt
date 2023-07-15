package domain

import data.remote.dto.CurrentLocation
import data.repository.WeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetCurrentLocationUseCase: KoinComponent{

    private val location: WeatherRepository by inject()

    suspend operator fun invoke(): CurrentLocation {
        return location.getCurrentLocation()
    }

}