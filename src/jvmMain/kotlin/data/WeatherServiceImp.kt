package data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class WeatherServiceImp(
    private val client: HttpClient
): WeatherService {


    companion object{
        fun create(): WeatherService{
            return WeatherServiceImp(
                client = HttpClient(CIO){
                    install(ContentNegotiation){
                        json(
                            Json {
                                ignoreUnknownKeys = true
                            }
                        )
                    }
                }
            )
        }
    }

}