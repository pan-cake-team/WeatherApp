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
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class WeatherViewModel: KoinComponent {


    private val getCurrentLocation: GetCurrentLocationUseCase by inject()
    private val getHourlyWeather: GetHourlyWeatherUseCase by inject()
    private val getDailyWeather: GetDailyWeatherUseCase by inject()

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
            viewModuleScope.cancel()
        }
    }
}