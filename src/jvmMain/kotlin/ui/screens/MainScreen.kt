package ui.screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import ui.screens.composable.LeftSide
import ui.screens.composable.RightSide


@Composable
fun MainScreen(
    viewModel: MainViewModel,
) {

    val state by viewModel.state.collectAsState()

    MainContent(
        state = state,
        onWeatherDayItemClicked = viewModel::onWeatherDayItemClicked
    )
}

@Composable
fun MainContent(
    state: MainUIState,
    onWeatherDayItemClicked: (DaysInterval) -> Unit,
) {
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

            LeftSide(state)

            RightSide(state = state, onWeatherDayItemClicked = onWeatherDayItemClicked)

        }
    }

}


@Preview
@Composable
fun PreviewHomeScreen() {
}