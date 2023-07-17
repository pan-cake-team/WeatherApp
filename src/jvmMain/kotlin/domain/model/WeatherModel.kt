package domain.model

data class WeatherModel(
    val location: String?,
    val data: List<DaysForCast>?,
)

data class DaysForCast(
    val weatherType: String?,
    val maxTemp: Double?,
    val minTemp: Double?,
    val date: String?,
    val icon: String?,
    val precipitation: Double?,
    val dayWindSpeed: Double?,
    val willItSnow: Int?,
    val willItRain: Int?,
    val days: List<HourlyWeather>?
)

data class HourlyWeather(
    val localtime: String?,
    val temp_c: Double?,
    val icon: String?,
    val hourlyWillItSnow: Int?,
    val hourlyWillItRain: Int?,
    val weatherType: String?,
)
