package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherCodeIconMapping(
    val weatherCodes: List<Int>, val icon: String,
)
