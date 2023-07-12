package data



import data.dto.Respone2
 import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.client.request.get

import kotlinx.serialization.SerializationException

import kotlinx.serialization.json.Json

class WeatherServiceImp(
    private val client: HttpClient
) : WeatherService {


    companion object {
        fun create(): WeatherService {
            return WeatherServiceImp(
                client = HttpClient(CIO) {
                    install(ContentNegotiation) {
                        json(Json {
                            ignoreUnknownKeys = true
                        }
                        )
                    }
                }
            )
        }
    }

    override suspend fun getDailyWeather(lat: Double, lon: Double): Respone2 {
        val url =
            "http://api.openweathermap.org/data/2.5/forecast/?lat=44.34&lon=10.99&appid=545c025aec18c326d80f41ac17e459b0&units=imperial"
        return try {
            client.get {
                url(url)
            }.body<Respone2>()
        } catch (e: SerializationException) {
            val error: Respone2.ErrorResponse = client.get {
                url(url)
            }.body<Respone2.ErrorResponse>()
            throw Exception(error.message)
        }
    }

    override suspend fun getHourWeather(cityId: Int): Respone2 {
        val url =
            "http://api.openweathermap.org/data/2.5/forecast?id=1851632&appid=545c025aec18c326d80f41ac17e459b0&units=imperial"
        return try {
            client.get {
                url(url)
            }.body<Respone2>()
        } catch (e: SerializationException) {
            val error: Respone2.ErrorResponse = client.get {
                url(url)
            }.body<Respone2.ErrorResponse>()
            throw Exception(error.message)
        }
    }
}
