package domain.model

import ui.screens.DaysInterval

data class WeatherModel(
    val location: String?,
    val data: List<DaysForCast>,
)

data class DaysForCast(
    val weatherType: String?,
    val maxTemp: Double?,
    val minTemp: Double?,
    val date: String?,
    val days: List<WeatherForcastModel>
)

data class WeatherForcastModel(
    val dayMaxTemp: Double?,
    val dayMinTemp: Double?,
    val dayWindSpeed: Double?,
    val precipitation: Double?,
    val weatherType: String?,
    val hourlyWeather: List<HourlyWeather>?,
)

data class HourlyWeather(
    val localtime: String,
    val temp_c: Double,
    val weatherType: String,
)

//data class HourlyWeather(
//    val time: String,
//    val temperature: Double,
//    val weatherType: String,
//    val weatherIconUrl: String
//)


