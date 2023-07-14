package domain.model


data class DailyWeather(
    val text: String,
    val localtime: String,
    val last_updated: String,
    val temp_c: Double,
    val icon: Int,
    val wind_mph: Double,
    val wind_kph: Double,
)

//data class DailyWeather(
//    val date : String,
//    val temperature: Double,
//    val humidity: Double,
//    val temperatureMin: Double,
//    val weatherType: String,
//    val weatherIconUrl: String,
//    val windSpeed: Double,
//)
