package data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class IntervalDTO(
    @SerialName("startTime")
    val startTime: String,
    @SerialName("values")
    val values: WeatherDataDTO
)

