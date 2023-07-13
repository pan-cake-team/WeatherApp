
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import data.remote.WeatherServiceImp
import data.repository.WeatherRepositoryImp
import data.remote.initKoin
import kotlinx.coroutines.runBlocking
import ui.theme.TextPrimary
import ui.theme.textSize80
import ui.theme.typography
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screens.MainScreen


@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val koin = initKoin()


    MaterialTheme {
        MainScreen()
    }
}


fun main()= application {
    Window(title = "Weather", onCloseRequest = ::exitApplication) {
        App()

    runBlocking {
        val weatherService = WeatherServiceImp.create()

        val repository = WeatherRepositoryImp(weatherService)
        val dailyWeather = repository.getDailyWeather(40.75872069597532, -73.98529171943665)
        val hourlyWeather = repository.getHourWeather(40.75872069597532, -73.98529171943665)

        println(dailyWeather)
        println(hourlyWeather)
    }
}
