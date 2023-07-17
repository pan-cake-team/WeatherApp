package ui.screens

import ui.theme.ImageClearSky
import ui.theme.ImageFoggy

data class MainUIState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val location: String? = "",
    val todayTemp: Int = 0,
    val todayMinTemp: Int = 0,
    val windSpeed: Double = 0.0,
    val precipitation: Int = 0,
    val backGround: String = ImageClearSky,
    val date: String = "",
    val weatherType: String = "",
    val isSearching:Boolean = false,
    val hours: List<DayHourIntervals> = emptyList(),
    val days: List<DaysInterval> = emptyList(),
)

data class DayHourIntervals(
    val hour: String = "",
    val weatherType: String = "",
    val icons: String = "",
    val temp: Int = 0,
)

data class DaysInterval(
    val date: String = "",
    val icons: String = "",
    val weatherType: String = "",
    val maxTemp: Double = 0.0,
    val minTemp: Double = 0.0,
    val backGround: String,
    val hours: List<DayHourIntervals> = emptyList(),
)
