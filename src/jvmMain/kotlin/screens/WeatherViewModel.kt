package screens

import domain.GetCityLocationUseCase
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
    private val getCityLocation: GetCityLocationUseCase,

) {

    private val _weatherUiState = MutableStateFlow(WeatherUiState())
    val weatherUiState = _weatherUiState.asStateFlow()

    private val viewModuleScope = CoroutineScope(Dispatchers.IO)

    init {
        getDailyWeatherData()
    }

    private fun getDailyWeatherData() {
        viewModuleScope.launch {
//            getDailyWeather.GetDailyWeatherData()
            viewModuleScope.cancel()
        }
    }

}