package data.remote.response.mapper

import data.domain.entity.DailyWeather
import data.domain.entity.HourlyWeather
import data.remote.dto.IntervalDTO

fun List<IntervalDTO>.toDailyWeather(): List<DailyWeather> {
    return map {
        DailyWeather(
            date = it.startTime,
            temperature = it.values.temperature ?: 0.0 ,
            temperatureMin = it.values.temperatureMin ?: 0.0 ,
            weatherCode = it.values.weatherCode ?: 0,
            windSpeed = it.values.windSpeed ?: 0.0,
            windGust = it.values.windGust ?: 0.0
        )
    }
}


fun List<IntervalDTO>.toHourlyWeather(): List<HourlyWeather> {
    return map {
        HourlyWeather(
            date = it.startTime,
            temperature = it.values.temperature ?: 0.0 ,
            weatherCode = it.values.weatherCode ?: 0,
        )
    }
}