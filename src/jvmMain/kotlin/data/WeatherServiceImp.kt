package data

import data.dto.Response
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

import kotlinx.serialization.json.Json

class WeatherServiceImp(
    private val client: HttpClient
): WeatherService {


    companion object{
        fun create(): WeatherService{
            return WeatherServiceImp(
                client = HttpClient(CIO){
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

    override suspend fun getDailyWeather(): Response {
        val url = "https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature,weatherCode,precipitationType,windSpeed,temperatureMin&timesteps=1d&units=metric&apikey=4GlgD02C1ehNPP1kvu5iFj2m9VAuZjE5"
        val response = client.get {
            url(url)
        }.body<Response>()
        return response
    }

    override suspend fun getHourWeather(): Response {
        val url = "https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature,weatherCode,precipitationType,windSpeed,temperatureMin&timesteps=1h&units=metric&apikey=4GlgD02C1ehNPP1kvu5iFj2m9VAuZjE5"
        val response = client.get {
            url(url)
        }.body<Response>()
        return response
    }
}