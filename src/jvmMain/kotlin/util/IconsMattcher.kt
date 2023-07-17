package util

import domain.model.WeatherCodeIconMapping
import ui.theme.*

fun getIconForWeatherCode(weatherCode: Int): String {
    val matchingMapping = mappings.find { weatherCode in it.weatherCodes }
    return matchingMapping?.icon ?: Sunny
}


val mappings = listOf(
    WeatherCodeIconMapping(listOf(1000), Sunny),
    WeatherCodeIconMapping(listOf(1003), CloudSun ),
    WeatherCodeIconMapping(listOf(1006), Cloud ),
    WeatherCodeIconMapping(listOf(1009), Clouds ),
    WeatherCodeIconMapping(listOf(1030, 1135, 1147), Fog ),
    WeatherCodeIconMapping(listOf(1063, 1180, 1183, 1186, 1189), CloudWaterdrop ),
    WeatherCodeIconMapping(listOf(
        1066, 1114, 1117, 1171, 1198, 1201, 1204, 1207,
        1210, 1219, 1222, 1225, 1249, 1252, 1255, 1258,
    ), CloudSnowfallMinimalistic ),
    WeatherCodeIconMapping(listOf(1069, 1072, 1237,1261, 1264 ), Snowflake ),
    WeatherCodeIconMapping(listOf(1087), CloudBoltMinimalistic ),
    WeatherCodeIconMapping(listOf(1192, 1195, 1240, 1243, 1246), IconCloudRaining ),
    WeatherCodeIconMapping(listOf(1273, 1276, 1279, 1282), CloudStorm ),
    WeatherCodeIconMapping(listOf(1150, 1153), Waterdrops),
)
