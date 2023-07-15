package domain.model

import ui.screens.DaysInterval

data class WeatherModel(
    val location: String?,
    val data: List<DaysForCast>?,
)

data class DaysForCast(
    val weatherType: String?,
    val maxTemp: Double?,
    val minTemp: Double?,
    val date: String?,
    val precipitation: Double?,
    val dayWindSpeed: Double?,
    val days: List<HourlyWeather>?
)

data class HourlyWeather(
    val localtime: String?,
    val temp_c: Double?,
    val weatherType: String?,
)

//data class HourlyWeather(
//    val time: String,
//    val temperature: Double,
//    val weatherType: String,
//    val weatherIconUrl: String
//)


