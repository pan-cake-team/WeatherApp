package data.repository

import data.remote.WeatherService
import domain.model.DailyWeather
import domain.model.HourlyWeather
import data.remote.dto.Location

import domain.model.Forecast

class WeatherRepositoryImp(private val weatherService: WeatherService) : WeatherRepository {


//    override suspend fun getDailyWeather(lat: Double, lon: Double): List<DailyWeather> {
//        return weatherService.getDailyWeather(lat, lon).toDailyWeather()
//    }
//
//    override suspend fun getHourWeather(lat: Double, lon: Double): List<HourlyWeather> {
//        return weatherService.getHourWeather(lat,lon).toHourlyWeather()
//    }

    override suspend fun getForecastDay(): List<Forecast> {
        return weatherService.getForecast().map {
            Forecast(
                date = it.date,
                dayWeather = DailyWeather(
                    date = it.date,
                    temperature = it.day.maxtempC,
                    temperatureMin = it.day.mintempC,
                    windSpeed = it.day.maxwindKph,
                    weatherIconUrl = it.day.condition.icon,
                    weatherType = it.day.condition.text,
                    humidity =it.day.avghumidity,
                ),
                hourlyWeather = it.hour.map { hour ->
                    HourlyWeather(
                        time = hour.time,
                        temperature = hour.tempC,
                        weatherType = hour.condition.text,
                        weatherIconUrl = hour.condition.icon
                    )
                }
            )
        }
    }

    override suspend fun getCurrentLocation(): Location {
        return weatherService.getLocation()
    }

    override suspend fun getDailyWeather(lat: Double, lon: Double): List<DailyWeather> {
        TODO("Not yet implemented")
    }

    override suspend fun getHourWeather(lat: Double, lon: Double): List<HourlyWeather> {
        TODO("Not yet implemented")
    }
}