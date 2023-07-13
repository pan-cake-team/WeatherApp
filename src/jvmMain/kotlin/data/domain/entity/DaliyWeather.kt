package data.domain.entity

data class DailyWeather(

    val date : String,
    val temperature: Double,
    val windGust: Double,
    val temperatureMin: Double,
    val weatherCode: Int,
    val windSpeed: Double

)