
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screens.MainScreen


@Composable
@Preview
fun App() {
    val image = "foggy.png"
    MaterialTheme {
        MainScreen()
    }
}


fun main()= application {
    Window(title = "Weather", onCloseRequest = ::exitApplication) {
        App()
    }
}
