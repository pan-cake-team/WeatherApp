package ui.screens

data class HourlyUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val date: String = "",
    val weatherType: String = "",
    val values: List<DayHourIntervals> = emptyList()
)

data class DayHourIntervals(
    val hour: String = "1212",
    val weatherType: String = "asdffsaf",
    val temp: Int = 0,
)

data class DailyUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val todayTemp: Int = 0,
    val todayMinTemp: Int = 0,
    val windSpeed: Double = 0.0,
    val precipitation: Int = 0,
    val days: List<DaysInterval> = emptyList(),
)


data class DaysInterval(
    val day: String = "",
    val weatherType: String = "",
    val maxTemp: Int = 0,
    val minTemp: Int = 0,
    val windGust: Double,
    val windSpeed: Double,
)
