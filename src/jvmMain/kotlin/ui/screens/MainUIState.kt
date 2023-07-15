package ui.screens



data class MainUIState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val location: String = "",
    val todayTemp: Int = 0,
    val todayMinTemp: Int = 0,
    val windSpeed: Double = 0.0,
    val precipitation: Int = 0,
    val date: String = "",
    val weatherType: String = "",
    val hours: List<DayHourIntervals> = emptyList(),
    val days: List<DaysInterval> = emptyList(),
)

data class DayHourIntervals(
    val hour: String = "1212",
    val weatherType: String = "asdffsaf",
    val temp: Int = 0,
)

data class DaysInterval(
    val date: String = "",
    val weatherType: String = "",
    val maxTemp: Double = 0.0,
    val minTemp: Double = 0.0,
)
