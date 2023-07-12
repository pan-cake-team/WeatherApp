package data

import data.dto.Respone2



interface WeatherService {
    suspend fun getDailyWeather(lat: Double, lon: Double): Respone2
    suspend fun getHourWeather(cityId: Int): Respone2
}