package ui.screens.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.screens.MainUIState
import ui.theme.TextSecondary
import ui.theme.typography

@Composable
fun LeftSide(
    state: MainUIState,
) {



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
            LazyRow   (
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(start = 16.dp),
            ) {
                items(state.hours) { hourlyData ->
                    WeatherTimeCard(time = hourlyData.hour, number = hourlyData.temp, icons = hourlyData.icons)
                }
            }
        }

    }

}