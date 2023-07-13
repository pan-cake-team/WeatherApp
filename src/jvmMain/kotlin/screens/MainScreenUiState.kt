package screens

data class MainScreenUiState(
    val todayIntervals: DayHourIntervals,
    val daysIntervals: DaysInterval
)

data class DayHourIntervals(
    val hour: String,
    val weatherType: String,
    val temp: Int,
)

data class DaysInterval(
    val day: String,
    val weatherType: String,
    val maxTemp: Int,
    val minTemp: Int,
)
