package domain

import data.remote.dto.Forecastday
import data.remote.dto.Hour
import data.remote.dto.WeatherForecastDto
import domain.model.DailyWeather
import data.repository.WeatherRepository
import domain.model.DaysForCast
import domain.model.Forecast
import domain.model.HourlyWeather
import domain.model.WeatherModel
import ui.screens.DaysInterval


class GetDailyWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
) {
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

fun Forecastday.toDaysForcast(): DaysForCast {
    return DaysForCast(
        weatherType = day?.condition?.text,
        date = date,
        maxTemp = day?.maxtempC,
        minTemp = day?.mintempC,
        days = this.hour?.map { it.toHourlyWeather() },
        precipitation = day?.totalprecipMm,
        dayWindSpeed = day?.maxwindKph,
        willItRain = day?.dailyWillItRain,
        willItSnow = day?.dailyWillItSnow,
    )
}

fun Hour.toHourlyWeather(): HourlyWeather {
    return HourlyWeather(
        localtime = time?.drop(11),
        weatherType = condition?.text,
        temp_c = tempC,
        hourlyWillItRain = willItRain,
        hourlyWillItSnow = willItSnow,
    )
}