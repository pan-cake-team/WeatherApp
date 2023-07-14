package ui.screens.left_side

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.java.KoinJavaComponent.inject
import ui.screens.composable.DateCard
import ui.screens.composable.HorizontalLine
import ui.screens.composable.SpacerVertical
import ui.screens.composable.WeatherTimeCard
import ui.theme.TextSecondary
import ui.theme.typography

@Composable
fun LeftSide(
    viewModel: HourlySideViewModel
) {

    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier.padding(40.dp).fillMaxWidth(.6f).fillMaxHeight(),
    ) {
        DateCard(
            state = state,
            modifier = Modifier
                .align(Alignment.TopEnd)
        )


        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .wrapContentWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ) {

            Text(state.weatherType, style = typography.h1, color = TextSecondary)
            HorizontalLine()
            SpacerVertical(32)
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(start = 16.dp),
            ) {
                items(state.values) { hourlyData ->
                    WeatherTimeCard(time = hourlyData.hour, number = hourlyData.temp)
                }
            }
        }

    }

}