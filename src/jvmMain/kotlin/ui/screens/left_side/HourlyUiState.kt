package ui.screens.left_side


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
