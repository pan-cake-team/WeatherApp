package domain.model

data class Forecast(
    val date: String,
    val dayWeather: DailyWeather,
    val hourlyWeather: List<HourlyWeather>,
)