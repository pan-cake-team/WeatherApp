package domain

import data.domain.entity.DailyWeather
import data.repository.WeatherRepository
import screens.DailyUiState
import screens.DaysInterval


class GetDailyWeatherUseCase(
    private val dailyWeatherResponse: WeatherRepository
) {
    suspend operator fun invoke(lat: Double, lon: Double): DailyUiState {
        return dailyWeatherResponse.getDailyWeather(lat, lon).toDailyUiState()
    }
}

private fun List<DailyWeather>.toDailyUiState(): DailyUiState {
    return this.let { dailyWeathers ->
        DailyUiState(
            todayTemp = dailyWeathers[0].temperature.toInt(),
            todayMinTemp = dailyWeathers[0].temperatureMin.toInt(),
            windSpeed = dailyWeathers[0].windSpeed,
            precipitation = dailyWeathers[0].windSpeed.toInt(),
            days = dailyWeathers.drop(1).map { it.toDailyInterval() },
        )
    }

}

private fun DailyWeather.toDailyInterval(): DaysInterval {
    return this.let {
        DaysInterval(
            day = date,
            minTemp = temperatureMin.toInt(),
            maxTemp = temperature.toInt(),
            weatherType = weatherCode.toString()
        )
    }
}