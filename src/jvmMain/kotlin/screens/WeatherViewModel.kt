package screens

import domain.GetWeatherUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
) {

    private val _weatherUiState = MutableStateFlow(WeatherUiState())
    val weatherUiState = _weatherUiState.asStateFlow()

    private val viewModuleScope = CoroutineScope(Dispatchers.IO)

    init {
        getWeatherData()
    }

    private fun getWeatherData() {
        viewModuleScope.launch {
            getWeatherUseCase.GetWeatherData()
            viewModuleScope.cancel()
        }
    }

}