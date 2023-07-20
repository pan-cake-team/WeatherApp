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
        onWeatherDayItemClicked = viewModel::onWeatherDayItemClicked,
        onSearch = viewModel::searchCityWeather,
        onClickSearch = viewModel::onClickSearch,
    )
}

@Composable
fun MainContent(
    state: MainUIState,
    onWeatherDayItemClicked: (DaysInterval) -> Unit,
    onSearch: (city: String) -> Unit,
    onClickSearch: () -> Unit,

    ) {
    Box(
        contentAlignment = Alignment.BottomEnd,
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(state.backGround),
            contentDescription = "",
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            LeftSide(state)

            RightSide(
                state,
                onWeatherDayItemClicked = onWeatherDayItemClicked,
                search = onSearch,
                onSearchIconClick = onClickSearch,
            )


        }
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
}