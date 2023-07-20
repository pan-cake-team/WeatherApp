import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import org.koin.core.Koin
import di.initKoin
import ui.screens.MainScreen


@Composable
@Preview
fun App(koin: Koin) {

    MaterialTheme {
        MainScreen(koin.get())
    }
}


fun main() = application {
    val koin = initKoin()

    val windowTitle by remember { mutableStateOf("Weather") }

    Window(
        state = rememberWindowState(),
        title = windowTitle,
        onCloseRequest = ::exitApplication,
        icon = painterResource("icons/Sunny.svg"),
//        undecorated = true,
//        transparent = true,
    ) {
        WindowDraggableArea {
            Box {
                App(koin)
            }

        }
    }
}