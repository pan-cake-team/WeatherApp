import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.WeatherServiceImp
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
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
        val dailyWeather = weatherService.getDailyWeather()
        val hourlyWeather = weatherService.getHourWeather()


        println(dailyWeather)
        println(hourlyWeather)
    }
}