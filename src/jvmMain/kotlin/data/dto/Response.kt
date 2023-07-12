package data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("data")
    val `data`: Data
) {
    @Serializable
    data class Data(
        @SerialName("timelines")
        val timelines: List<Timeline>
    ) {
        @Serializable
        data class Timeline(
            @SerialName("endTime")
            val endTime: String,
            @SerialName("intervals")
            val intervals: List<Interval>,
            @SerialName("startTime")
            val startTime: String,
            @SerialName("timestep")
            val timestep: String
        ) {
            @Serializable
            data class Interval(
                @SerialName("startTime")
                val startTime: String,
                @SerialName("values")
                val values: Values
            ) {
                @Serializable
                data class Values(
                    @SerialName("precipitationType")
                    val precipitationType: Int,
                    @SerialName("temperature")
                    val temperature: Double,
                    @SerialName("temperatureMin")
                    val temperatureMin: Double,
                    @SerialName("weatherCode")
                    val weatherCode: Int,
                    @SerialName("windSpeed")
                    val windSpeed: Double
                )
            }
        }
    }
}

fun getWeatherMeaning(weatherCode: Int): String {
    return when (weatherCode) {
        0 -> "Unknown"
        1000 -> "Clear, Sunny"
        1100 -> "Mostly Clear"
        1101 -> "Partly Cloudy"
        1102 -> "Mostly Cloudy"
        1001 -> "Cloudy"
        2000 -> "Fog"
        2100 -> "Light Fog"
        4000 -> "Drizzle"
        4001 -> "Rain"
        4200 -> "Light Rain"
        4201 -> "Heavy Rain"
        5000 -> "Snow"
        5001 -> "Flurries"
        5100 -> "Light Snow"
        5101 -> "Heavy Snow"
        6000 -> "Freezing Drizzle"
        6001 -> "Freezing Rain"
        6200 -> "Light Freezing Rain"
        6201 -> "Heavy Freezing Rain"
        7000 -> "Ice Pellets"
        7101 -> "Heavy Ice Pellets"
        7102 -> "Light Ice Pellets"
        8000 -> "Thunderstorm"
        else -> "Unknown Code"
    }
}