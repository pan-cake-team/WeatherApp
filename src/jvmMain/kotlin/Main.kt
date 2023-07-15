
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.remote.WeatherServiceImp
import data.repository.WeatherRepository
import data.repository.WeatherRepositoryImp
import org.koin.core.Koin
import di.initKoin
import domain.GetWeatherUseCase
import kotlinx.coroutines.runBlocking
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject
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
        App(koin)


        runBlocking {

            val repository: WeatherRepository by inject(WeatherRepository::class.java)
            val getDailyWeather: GetWeatherUseCase by inject(GetWeatherUseCase::class.java)
            val dailyWeather = getDailyWeather()

            println(dailyWeather)

        }
    }
}