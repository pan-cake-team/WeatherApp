package data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class WeatherDataDTO(
    @SerialName("windGust")
    val windGust: Double?= null,
    @SerialName("temperature")
    val temperature: Double?= null,
    @SerialName("temperatureMin")
    val temperatureMin: Double?= null,
    @SerialName("weatherCode")
    val weatherCode: Int?= null,
    @SerialName("windSpeed")
    val windSpeed: Double?= null
)