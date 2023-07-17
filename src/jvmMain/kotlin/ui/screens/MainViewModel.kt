package ui.screens

import domain.GetWeatherUseCase
import domain.SearchCityUseCase
import domain.model.DaysForCast
import domain.model.HourlyWeather
import domain.model.WeatherModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ui.base.BaseViewModel

class MainViewModel : KoinComponent, BaseViewModel<MainUIState>(MainUIState()) {

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
                    hours = getDailyWeather.data[0].days!!.map { hourlyWeather -> hourlyWeather.toHourIntervals() },
                )
            }
        }
    }

    private fun getDailyWeatherData() {
        viewModelScope.launch {
            val getDailyWeather = getDailyWeather()
            updateScreen(weather = getDailyWeather)
            }

    }

    fun onClickSearch() {
        updateState {
            it.copy(
                isSearching = true
            )
        }
    }

    fun searchCityWeather(city: String) {
        viewModelScope.launch {
            val searchCityUseCase = searchCityUseCase(city)
            updateScreen(weather = searchCityUseCase)
        }
    }

    private fun updateScreen(weather:WeatherModel) {
        updateState {
            it.copy(
                isLoading = false,
                todayTemp = weather.data?.get(0)?.maxTemp!!.toInt(),
                todayMinTemp = weather.data[0].minTemp!!.toInt(),
                windSpeed = weather.data[0].dayWindSpeed!!,
                precipitation = weather.data[0].precipitation!!.toInt(),
                backGround = weather.data[0].backGround,
                location = weather.location,
                isSearching = false,
                weatherType = weather.data[0].weatherType!!,
                date = weather.data[0].date!!,
                days = weather.data.map { daysForCast -> daysForCast.toDaysInterval() },
                hours = weather.data[0].days!!.map { hourlyWeather -> hourlyWeather.toHourIntervals() },
            )
        }
    }


    fun onWeatherDayItemClicked(day: DaysInterval) {
        updateState {
            it.copy(
                date = day.date,
                weatherType = day.weatherType,
                backGround = day.backGround,
                hours = day.hours
            )
        }

    }
}



fun HourlyWeather.toHourIntervals(): DayHourIntervals {
    return DayHourIntervals(
        hour = localtime!!,
        weatherType = weatherType!!,
        temp = temp_c?.toInt()!!,
        icons = icon!!
    )
}

fun DaysForCast.toDaysInterval(): DaysInterval {
    return DaysInterval(
        date = date!!,
        weatherType = weatherType!!,
        maxTemp = maxTemp!!,
        minTemp = minTemp!!,
        icons = icon!!,
        backGround = backGround,
        hours = days!!.map { it.toHourIntervals() },
    )
}