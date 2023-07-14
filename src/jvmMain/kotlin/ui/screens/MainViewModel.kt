package ui.screens

import domain.GetCityLocationUseCase
//import domain.GetDailyWeatherUseCase
import domain.GetHourlyWeatherUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ui.base.BaseViewModel

class MainViewModel : KoinComponent ,BaseViewModel<HourlyUiState,DailyUiState>(HourlyUiState(), DailyUiState())  {

    private val getHourlyWeather: GetHourlyWeatherUseCase by inject()
//    private val getDailyWeather: GetDailyWeatherUseCase by inject()
    private val getCityLocation: GetCityLocationUseCase by inject()}

//    init {
//        getHourlyWeatherData()
//        getDailyWeatherData()
//    }
//
//    private fun getHourlyWeatherData() {
//        viewModelScope.launch {
//            val getHourlyWeather = getHourlyWeather()
//            val getDailyWeather = getDailyWeather()
//            updateHourlyState {
//                it.copy(
//                    isLoading = false,
//                    date = getDailyWeather[0].day,
//                    weatherType = getDailyWeather[0].weatherType,
//                    values = getHourlyWeather
//                )
//            }
//        }
//    }
//
//    private fun getDailyWeatherData() {
//        viewModelScope.launch {
//            val getDailyWeather = getDailyWeather()
//            updateDailyState {
//                it.copy(
//                    isLoading = false,
//                    todayTemp = getDailyWeather[0].maxTemp,
//                    todayMinTemp = getDailyWeather[0].minTemp,
//                    windSpeed = getDailyWeather[0].windSpeed,
//                    precipitation = getDailyWeather[0].windGust.toInt(),
//                    days = getDailyWeather
//                )
//            }
//        }
//    }
//
//
//}