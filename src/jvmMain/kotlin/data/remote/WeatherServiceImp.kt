package data.remote

import data.remote.dto.IntervalDTO
import data.remote.dto.WeatherDataDTO
import data.remote.response.WeatherResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.client.request.get

import kotlinx.serialization.json.Json
import okhttp3.HttpUrl

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

        private const val HTTPS_SCHEME = "https"
        private const val BASE_URL = "api.tomorrow.io"
        private const val FIELDS_VULUE_DAILY = "temperature,weatherCode,windGust,temperatureMin,windSpeed"
        private const val FIELDS_VULUE_HOURLY = "temperature,weatherCode"
        private const val TIME_STEPS_DAILY = "1d"
        private const val TIME_STEPS_HOURLY = "1h"
        private const val CAIRO_TIME_ZONE = "Africa/Cairo"
        private const val TIME_LINES = "timelines"
        private const val LOCATION = "location"
        private const val FIELDS = "fields"
        private const val TIME_STEPS = "timesteps"
        private const val UNITS = "units"
        private const val APIKEY = "apikey"
        private const val APIKEY_VULUE = "4GlgD02C1ehNPP1kvu5iFj2m9VAuZjE5"
        private const val TIME_ZONE = "timezone"
        private const val CELSIUS_UNITS = "metric"
    }
    override suspend fun getDailyWeather(lat: Double, lon: Double): List<IntervalDTO> {
        val urlString = HttpUrl.Builder()
            .scheme(HTTPS_SCHEME)
            .host(BASE_URL)
            .addPathSegments("v4")
            .addPathSegment(TIME_LINES)
            .addQueryParameter(APIKEY, APIKEY_VULUE)
            .addQueryParameter(FIELDS, FIELDS_VULUE_DAILY)
            .addQueryParameter(LOCATION,"$lat,$lon")
            .addQueryParameter(TIME_STEPS, TIME_STEPS_DAILY)
            .addQueryParameter(UNITS, CELSIUS_UNITS)
            .addQueryParameter(TIME_ZONE, CAIRO_TIME_ZONE)
            .build()
            .toString()
        val response = client.get {
            url(urlString)
        }.body<WeatherResponse>()
        return wrapResponse(response)
    }
    override suspend fun getHourWeather(lat: Double, lon: Double):  List<IntervalDTO> {
        val urlString = HttpUrl.Builder()
            .scheme(HTTPS_SCHEME)
            .host(BASE_URL)
            .addPathSegments("v4")
            .addPathSegment(TIME_LINES)
            .addQueryParameter(APIKEY, APIKEY_VULUE)
            .addQueryParameter(FIELDS, FIELDS_VULUE_HOURLY)
            .addQueryParameter(LOCATION,"$lat,$lon")
            .addQueryParameter(TIME_STEPS, TIME_STEPS_HOURLY)
            .addQueryParameter(UNITS, CELSIUS_UNITS)
            .addQueryParameter(TIME_ZONE, CAIRO_TIME_ZONE)
            .build()
            .toString()
        val response = client.get {
            url(urlString)
        }.body<WeatherResponse>()
        return wrapResponse(response)
    }

    private fun wrapResponse(response: WeatherResponse): List<IntervalDTO> {
        return response.data.timelines.flatMap { timeline ->
            timeline.intervals.map { interval ->
                IntervalDTO(
                    startTime = interval.startTime,
                    values = WeatherDataDTO(
                        windGust = interval.values.windGust,
                        temperature = interval.values.temperature,
                        temperatureMin = interval.values.temperatureMin,
                        weatherCode = interval.values.weatherCode,
                        windSpeed = interval.values.windSpeed
                    )
                )
            }
        }
    }

}

