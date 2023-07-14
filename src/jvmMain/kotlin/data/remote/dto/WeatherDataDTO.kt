package data.remote.dto



data class WeatherDataDTO(
    val windGust: Double?= null,
    val temperature: Double?= null,
    val temperatureMin: Double?= null,
    val weatherCode: Int?= null,
    val windSpeed: Double?= null
)