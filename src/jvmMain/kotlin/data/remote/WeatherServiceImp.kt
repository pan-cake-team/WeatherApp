package data.remote

import com.google.gson.Gson
import data.remote.dto.ForecastDayDTO
import data.remote.dto.IntervalDTO
import data.remote.dto.Location
import data.remote.response.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.serialization.gson.gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL


class WeatherServiceImp(
    private val client: HttpClient
) : WeatherService {


    companion object {
        fun create(): WeatherService {
            return WeatherServiceImp(
                client = HttpClient(Java) {
                    install(ContentNegotiation) {
                        gson()
                    }
                }
            )
        }
    }

    override suspend fun getDailyWeather(lat: Double, lon: Double): List<IntervalDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun getHourWeather(lat: Double, lon: Double): List<IntervalDTO> {
        TODO("Not yet implemented")
    }

//    override suspend fun getDailyWeather(lat: Double, lon: Double): List<IntervalDTO> {
//        val response = client.get {
//        }.body<WeatherResponse>()
//        return wrapResponse(response)
//    }
//
//    override suspend fun getHourWeather(lat: Double, lon: Double): List<IntervalDTO> {
//        val response = client.get {
//        }.body<WeatherResponse>()
//        return wrapResponse(response)
//    }
//
//    private fun wrapResponse(response: WeatherResponse): List<IntervalDTO> {
//        return response.data.timelines.flatMap { timeline ->
//            timeline.intervals.map { interval ->
//                IntervalDTO(
//                    startTime = interval.startTime,
//                    values = WeatherDataDTO(
//                        windGust = interval.values.windGust,
//                        temperature = interval.values.temperature,
//                        temperatureMin = interval.values.temperatureMin,
//                        weatherCode = interval.values.weatherCode,
//                        windSpeed = interval.values.windSpeed
//                    )
//                )
//            }
//        }
//    }

    override suspend fun getLocation(): Location {
        return withContext(Dispatchers.IO) {
            val url = URL("https://ipinfo.io/json")
            val json = url.readText()
            val data = Gson().fromJson(json, Location::class.java)
            val location = data.loc
            Location(loc = location)
        }
    }

    override suspend fun getForecast(): List<ForecastDayDTO> {
        val url =
            "http://api.weatherapi.com/v1/forecast.json?key=3ef614045e38444fac0205724231407&q=Baghdad&days=1&hourly=1"
        val response = client.get {
            url(url)
        }.body<WeatherResponse>()
       return response.forecast.forecastday
    }

}