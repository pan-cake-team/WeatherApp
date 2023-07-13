package screens

import domain.GetCurrentLocationUseCase
import domain.GetDailyWeatherUseCase
import domain.GetHourlyWeatherUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getCurrentLocation: GetCurrentLocationUseCase,
    private val getHourlyWeather: GetHourlyWeatherUseCase,
    private val getDailyWeather: GetDailyWeatherUseCase,
//    private val getCityLocation: GetCityLocationUseCase,
    ) {

    private val _dailyUiState = MutableStateFlow(DailyUiState())
    val dailyUiState = _dailyUiState.asStateFlow()

    private val _hourlyUiState = MutableStateFlow(HourlyUiState())
    val hourlyUiState = _hourlyUiState.asStateFlow()

    private val viewModuleScope = CoroutineScope(Dispatchers.IO)

    init {
        getHourlyWeatherData()
        getDailyWeatherData()
    }

    private fun getHourlyWeatherData() {
        viewModuleScope.launch {
            getCurrentLatLong()
            val lat = _dailyUiState.value.lat
            val long = _dailyUiState.value.long
            getHourlyWeather(lat ,long)
            viewModuleScope.cancel()
        }
    }

    private fun getDailyWeatherData() {
        viewModuleScope.launch {
            getCurrentLatLong()
            val lat = _dailyUiState.value.lat
            val long = _dailyUiState.value.long
            getDailyWeather(lat ,long)
            viewModuleScope.cancel()
        }
    }

    private fun getCurrentLatLong() {
        viewModuleScope.launch {
            val currentLocation = getCurrentLocation()
            val (lat,long) = currentLocation
            _dailyUiState.update { it.copy(lat = lat, long = long) }
            _hourlyUiState.update { it.copy(lat = lat, long = long) }
            viewModuleScope.cancel()
        }
    }
}