
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.remote.WeatherServiceImp
import data.repository.WeatherRepositoryImp
import org.koin.core.Koin
import di.initKoin
import kotlinx.coroutines.runBlocking
import ui.screens.MainScreen



@Composable
@Preview
fun App(koin: Koin) {

    MaterialTheme {
        MainScreen(koin.get())
    }
}


fun main()= application {
    val koin = initKoin()
    Window(title = "Weather", onCloseRequest = ::exitApplication) {
//        App(koin)


        runBlocking {

            val weatherService = WeatherServiceImp.create()

            val repository = WeatherRepositoryImp(weatherService)
            val dailyWeather = repository.getForecastDay()
//            val hourlyWeather = repository.getHourWeather(40.75872069597532, -73.98529171943665)
//
//
            println(dailyWeather)
//            println(hourlyWeather)
        }
    }
}