package data.remote

import com.google.gson.Gson
import data.remote.dto.CurrentLocation
import data.remote.dto.WeatherForecastDto
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

    override suspend fun getLocation(): CurrentLocation {
        return withContext(Dispatchers.IO) {
            val url = URL("https://ipinfo.io/json")
            val json = url.readText()
            val data = Gson().fromJson(json, CurrentLocation::class.java)
            val location = data.loc
            CurrentLocation(loc = location)
        }
    }

    override suspend fun getForecast(): WeatherForecastDto {
        val url =
            "http://api.weatherapi.com/v1/forecast.json?key=3ef614045e38444fac0205724231407&q=cairo&days=9"
        val response = client.get {
            url(url)
        }.body<WeatherForecastDto>()
       return response
    }

}