package screens

// this is just bad I don't like it :(

data class HourlyUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val values: List<DayHourIntervals> = emptyList()
)

data class DailyUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val todayTemp: Int = 0,
    val todayMinTemp: Int = 0,
    val windSpeed: Double = 0.0,
    val precipitation: Int = 0,
    val lat: Double = 0.0,
    val long: Double = 0.0,
    val days: List<DaysInterval> = emptyList(),
)

data class DayHourIntervals(
    val hour: String = "",
    val weatherType: String = "",
    val temp: Int = 0,
)

data class DaysInterval(
    val day: String = "",
    val weatherType: String = "",
    val maxTemp: Int = 0,
    val minTemp: Int = 0,
)
