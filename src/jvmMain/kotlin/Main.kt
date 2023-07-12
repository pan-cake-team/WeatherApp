
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
@Preview
fun App() {
    val image = "foggy.png"
    MaterialTheme {
        Image(
            painter = painterResource("images/${image}"),
            contentDescription = "Foggy",
            modifier = Modifier.fillMaxSize(),
        )
    }
}


fun main()= application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
