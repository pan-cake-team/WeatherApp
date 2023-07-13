import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import data.remote.WeatherServiceImp
import di.weatherModule
import kotlinx.coroutines.runBlocking
import org.koin.core.context.GlobalContext.startKoin
import ui.theme.TextPrimary
import ui.theme.textSize80
import ui.theme.typography


@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    startKoin {
        modules(weatherModule)
    }

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
        val dailyWeather = weatherService.getDailyWeather()
        val hourlyWeather = weatherService.getHourWeather()


        println(dailyWeather)
        println(hourlyWeather)
    }
}