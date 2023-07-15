package ui.screens

import domain.GetWeatherUseCase
import domain.SearchCityUseCase
import domain.model.DaysForCast
import domain.model.HourlyWeather
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ui.base.BaseViewModel

class MainViewModel : KoinComponent ,BaseViewModel<MainUIState>(MainUIState())  {

    private val getDailyWeather: GetWeatherUseCase by inject()
    private val searchCityUseCase: SearchCityUseCase by inject()


    init {
        getHourlyWeatherData()
        getDailyWeatherData()
    }

    private fun getHourlyWeatherData() {
        viewModelScope.launch {
            val getDailyWeather = getDailyWeather()
            updateState {
                it.copy(
                    isLoading = false,
                    date = getDailyWeather.data?.get(0)?.date!!,
                    weatherType = getDailyWeather.data[0].weatherType!!,
                    hours = getDailyWeather.data[0].days!!.map { hourlyWeather -> hourlyWeather.toHourIntervals()},
                )
            }
        }
    }

    private fun getDailyWeatherData() {
        viewModelScope.launch {
            val getDailyWeather = getDailyWeather()
            updateState {
                it.copy(
                    isLoading = false,
                    todayTemp = getDailyWeather.data?.get(0)?.maxTemp!!.toInt(),
                    todayMinTemp = getDailyWeather.data[0].minTemp!!.toInt(),
                    windSpeed = getDailyWeather.data[0].dayWindSpeed!!,
                    precipitation = getDailyWeather.data[0].precipitation!!.toInt(),
                    days = getDailyWeather.data.map { daysForCast -> daysForCast.toDaysInterval() }
                )
            }
        }
    }

    private fun searchCityWeather(city: String) {
        viewModelScope.launch {
            val searchCityUseCase = searchCityUseCase(city)

        }
    }

}


fun HourlyWeather.toHourIntervals(): DayHourIntervals {
    return DayHourIntervals(
        hour = localtime!!,
        weatherType = weatherType!!,
        temp = temp_c?.toInt()!!,
    )
}

fun DaysForCast.toDaysInterval(): DaysInterval {
    return DaysInterval(
        date = date!!,
        weatherType = weatherType!!,
        maxTemp = maxTemp!!,
        minTemp = minTemp!!,
    )
}