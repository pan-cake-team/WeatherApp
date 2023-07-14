package data.remote

import com.google.gson.Gson
import data.remote.dto.IntervalDTO
import data.remote.dto.Location
import data.remote.dto.WeatherDataDTO
import data.remote.response.WeatherResponse
import di.weatherModule
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.Koin
import org.koin.core.context.startKoin
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
        private const val APIKEY_VULUE = "q95QTAsN8jVyhlFXgis2tgjUygiK4r5w"
        private const val TIME_ZONE = "timezone"
        private const val CELSIUS_UNITS = "metric"
    }
    override suspend fun getDailyWeather(lat: Double, lon: Double): List<IntervalDTO> {
        val response = client.get {
        }.body<WeatherResponse>()
        return wrapResponse(response)
    }
    override suspend fun getHourWeather(lat: Double, lon: Double):  List<IntervalDTO> {
        val response = client.get {
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

    override suspend fun getLocation(): Location {
        return withContext(Dispatchers.IO) {
            val url = URL("https://ipinfo.io/json")
            val json = url.readText()
            val data = Gson().fromJson(json, Location::class.java)
            val location = data.loc
            Location(loc = location)
        }
    }
}


fun initKoin(): Koin =
    startKoin {
        modules(weatherModule)
    }.koin
