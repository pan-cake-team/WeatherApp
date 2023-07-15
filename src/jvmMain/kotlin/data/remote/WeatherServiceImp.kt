package data.remote

import com.google.gson.Gson
import data.remote.dto.CurrentLocation
import data.remote.dto.WeatherForecastDto
import data.util.Constants.DAYS
import data.util.Constants.KEY
import data.util.Constants.QUERY
import data.util.HttpRoute
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL


open class WeatherServiceImp(
    private val client: HttpClient
) : WeatherService {

    override suspend fun getLocation(): CurrentLocation {
        return withContext(Dispatchers.IO) {
            val url = URL(HttpRoute.LOCATION_URL)
            val json = url.readText()
            val data = Gson().fromJson(json, CurrentLocation::class.java)
            val location = data.loc
            CurrentLocation(loc = location)
        }
    }

    override suspend fun getForecast(latLongLocation: String): WeatherForecastDto {
        return client.get {
            url(HttpRoute.FORECAST)
            parameter(KEY, HttpRoute.KEY)
            parameter(QUERY, latLongLocation)
            parameter(DAYS, "9")
        }.body()
    }


    override suspend fun searchForecast(city: String): WeatherForecastDto {
        return client.get {
            url(HttpRoute.FORECAST)
            parameter(KEY, HttpRoute.KEY)
            parameter(QUERY, city)
            parameter(DAYS, "9")
        }.body()
    }
}