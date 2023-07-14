package ui.screens.left_side

import domain.GetDailyWeatherUseCase
import domain.GetHourlyWeatherUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ui.base.BaseViewModel

class HourlySideViewModel : KoinComponent ,BaseViewModel<HourlyUiState>(HourlyUiState()) {

    private val getHourlyWeather: GetHourlyWeatherUseCase by inject()
    private val getDailyWeatherUseCase: GetDailyWeatherUseCase by inject()

    init {
        getHourlyWeatherData()
    }

    private fun getHourlyWeatherData() {
        viewModelScope.launch {
            val getHourlyWeather = getHourlyWeather()
            val getDailyWeather = getDailyWeatherUseCase()
            updateState {
                it.copy(
                    isLoading = false,
                    date = getDailyWeather[0].day,
                    weatherType = getDailyWeather[0].weatherType,
                    values = getHourlyWeather
                )
            }
        }
    }
}