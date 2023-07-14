package domain.model

data class HourlyWeather(
    val time: String,
    val temperature: Double,
    val weatherType: String,
    val weatherIconUrl: String
)
