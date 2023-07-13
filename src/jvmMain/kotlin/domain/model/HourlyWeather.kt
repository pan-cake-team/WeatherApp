package domain.model

data class HourlyWeather(
    val date: String,
    val temperature: Double,
    val weatherCode: Int,
)
