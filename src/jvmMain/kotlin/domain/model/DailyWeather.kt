package domain.model

data class DailyWeather(
    val date : String,
    val temperature: Double,
    val humidity: Double,
    val temperatureMin: Double,
    val weatherType: String,
    val weatherIconUrl: String,
    val windSpeed: Double,
)