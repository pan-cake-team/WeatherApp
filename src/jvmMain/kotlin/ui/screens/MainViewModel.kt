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

    private fun updateScreen(weather: WeatherModel) {
        weather.data?.get(0)?.let { weatherData ->
            updateState {
                it.copy(
                    isLoading = false,
                    todayTemp = weatherData.maxTemp?.toInt() ?: 0,
                    todayMinTemp = weatherData.minTemp?.toInt() ?: 0,
                    windSpeed = weatherData.dayWindSpeed ?: 0.0,
                    precipitation = weatherData.precipitation?.toInt() ?: 0,
                    backGround = weatherData.backGround,
                    location = weather.location,
                    isSearching = false,
                    weatherType = weatherData.weatherType ?: "",
                    date = weatherData.date ?: "",
                    days = weather.data?.map { daysForCast -> daysForCast.toDaysInterval() } ?: listOf(),
                    hours = weatherData.days?.map { hourlyWeather -> hourlyWeather.toHourIntervals() } ?: listOf(),
                )
            }
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