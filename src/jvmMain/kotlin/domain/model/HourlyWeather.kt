package domain.model


data class HourlyWeather(
    val localtime: String,
    val last_updated: String,
    val temp_c: Double,
    val icon: Int,
)

//data class HourlyWeather(
//    val time: String,
//    val temperature: Double,
//    val weatherType: String,
//    val weatherIconUrl: String
//)


