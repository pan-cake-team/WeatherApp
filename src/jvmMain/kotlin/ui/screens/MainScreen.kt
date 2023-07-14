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

    val dailyUiState by viewModel.state2.collectAsState()
    val hourlyUiState by viewModel.state.collectAsState()

    MainContent(
        dailyUiState = dailyUiState,
        hourlyUiState = hourlyUiState,
    )
}

@Composable
fun MainContent(
    dailyUiState: DailyUiState,
    hourlyUiState: HourlyUiState,

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

            LeftSide(hourlyUiState)

            RightSide(dailyUiState)

        }
    }

}


@Preview
@Composable
fun PreviewHomeScreen() {
}