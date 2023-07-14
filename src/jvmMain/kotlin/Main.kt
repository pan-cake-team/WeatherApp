
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import data.remote.WeatherServiceImp
import data.repository.WeatherRepositoryImp
import kotlinx.coroutines.runBlocking
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.initKoin
import org.koin.core.Koin
import ui.screens.left_side.LeftSide
import ui.screens.right_side.RightSide


@Composable
@Preview
fun App(koin: Koin) {

    MaterialTheme {
        Box(
            contentAlignment = Alignment.BottomEnd,
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                painter = painterResource("images/foggy.png"),
                contentDescription = "",
            )



            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                LeftSide(koin.get())

                RightSide(koin.get())

            }
        }
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