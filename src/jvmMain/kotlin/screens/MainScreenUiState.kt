package screens

data class HourlyUiState(
    val values: List<DayHourIntervals>
)

data class DailyUiState(
    val days: List<DaysInterval>
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
