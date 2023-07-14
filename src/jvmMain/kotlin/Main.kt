
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.remote.WeatherServiceImp
import data.remote.initKoin
import data.repository.WeatherRepositoryImp
import kotlinx.coroutines.runBlocking
import org.koin.core.Koin
import screens.MainScreen


@Composable
@Preview
fun App(koin: Koin) {
    var text by remember { mutableStateOf("Hello, World!") }
    MaterialTheme {
        MainScreen()
    }
}


fun main()= application {
    val koin = initKoin()
    Window(title = "Weather", onCloseRequest = ::exitApplication) {
        App(koin)
        runBlocking {
            val weatherService = WeatherServiceImp.create()

            val repository = WeatherRepositoryImp(weatherService)
            val dailyWeather = repository.getDailyWeather(40.75872069597532, -73.98529171943665)
            val hourlyWeather = repository.getHourWeather(40.75872069597532, -73.98529171943665)

            println(dailyWeather)
            println(hourlyWeather)
        }
    }
}