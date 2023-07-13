package screens

import domain.GetCurrentLocationUseCase
import domain.GetDailyWeatherUseCase
import domain.GetHourlyWeatherUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getCurrentLocation: GetCurrentLocationUseCase,
    private val getHourlyWeather: GetHourlyWeatherUseCase,
    private val getDailyWeatherUseCase: GetDailyWeatherUseCase,
//    private val getCityLocation: GetCityLocationUseCase,
    ) {

    private val _dailyUiState = MutableStateFlow(DailyUiState())
    val dailyUiState = _dailyUiState.asStateFlow()

    private val _hourlyUiState = MutableStateFlow(HourlyUiState())
    val hourlyUiState = _hourlyUiState.asStateFlow()

    private val viewModuleScope = CoroutineScope(Dispatchers.IO)

    init {
        getDailyWeatherData()
    }

    private fun getDailyWeatherData() {
        viewModuleScope.launch {
            // use ui state
            getDailyWeatherUseCase(22.9 ,11.2)
            viewModuleScope.cancel()
        }
    }

    private fun getCurrentLocation() {
        viewModuleScope.launch {
            val currentLocation = getCurrentLocation()
            // update ui state daily and hourly
            viewModuleScope.cancel()
        }
    }
}