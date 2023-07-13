package domain

import data.remote.dto.Location
import data.repo.WeatherRepo

class GetCurrentLocationUseCase(
    private val weatherRepo: WeatherRepo
) {

    suspend operator fun invoke(): Location {
        return weatherRepo.getCurrentLocation()
    }


}