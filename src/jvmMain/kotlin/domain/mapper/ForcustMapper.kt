package domain.mapper

import data.remote.dto.Forecastday
import data.remote.dto.Hour
import domain.model.DaysForCast
import domain.model.HourlyWeather
import util.getIconForWeatherCode

fun Forecastday.toDaysForcast(): DaysForCast {
    return DaysForCast(
        weatherType = day?.condition?.text,
        date = date,
        maxTemp = day?.maxtempC,
        minTemp = day?.mintempC,
        days = this.hour?.map { it.toHourlyWeather() },
        precipitation = day?.totalprecipMm,
        dayWindSpeed = day?.maxwindKph,
        willItRain = day?.dailyWillItRain,
        willItSnow = day?.dailyWillItSnow,
        icon = getIconForWeatherCode(day?.condition?.code!!)
    )
}

fun Hour.toHourlyWeather(): HourlyWeather {
    return HourlyWeather(
        localtime = time?.drop(11),
        weatherType = condition?.text,
        temp_c = tempC,
        hourlyWillItRain = willItRain,
        hourlyWillItSnow = willItSnow,
        icon = getIconForWeatherCode(condition?.code!!)
    )
}


