package ui.screens.right_side

import domain.GetCityLocationUseCase
import domain.GetDailyWeatherUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ui.base.BaseViewModel

class DailySideViewModel: KoinComponent, BaseViewModel<DailyUiState>(DailyUiState()) {

    private val getDailyWeather: GetDailyWeatherUseCase by inject()
    private val getCityLocation: GetCityLocationUseCase by inject()

    init {
        getDailyWeatherData()
    }

    private fun getDailyWeatherData() {
        viewModelScope.launch {
            val getDailyWeather = getDailyWeather()
            updateState {
                it.copy(
                    isLoading = false,
                    todayTemp = getDailyWeather[0].maxTemp,
                    todayMinTemp = getDailyWeather[0].minTemp,
                    windSpeed = getDailyWeather[0].windSpeed,
                    precipitation = getDailyWeather[0].windGust.toInt(),
                    days = getDailyWeather
                )
            }
        }
    }


}