import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import data.WeatherServiceImp

import kotlinx.coroutines.runBlocking
import ui.theme.TextPrimary
import ui.theme.textSize80
import ui.theme.typography


@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text, style = typography.h1, color = TextPrimary, fontSize = textSize80)
        }
    }
}


fun main() {
    runBlocking {
        val weatherService = WeatherServiceImp.create()
        val dailyWeather = weatherService.getDailyWeather( 35.0,39.0)
        val hourlyWeather = weatherService.getHourWeather(1851632)


        println(dailyWeather)
        println(hourlyWeather)
    }
}