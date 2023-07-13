package screens

data class MainScreenUiState(
    val todayTemp: Int,
    val windSpeed: Int,
    val precipitation: Int,
    val todayIntervals: List<DayHourIntervals>,
    val daysIntervals: List<DaysInterval>
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
