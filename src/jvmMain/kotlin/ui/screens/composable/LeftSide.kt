package ui.screens.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ui.screens.MainUIState
import ui.theme.Space16
import ui.theme.Space40
import ui.theme.TextSecondary
import ui.theme.typography

@Composable
fun LeftSide(
    state: MainUIState,
) {



    Box(
        modifier = Modifier.fillMaxWidth(.8f).fillMaxHeight(),
    ) {
        DateCard(
            state = state,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(Space40)
        )


        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .wrapContentWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
        ) {

            Text(
                state.weatherType,
                style = typography.h1,
                color = TextSecondary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.padding(Space40)
            )
            HorizontalLine(modifier = Modifier.fillMaxWidth(.8f))
            SpacerVertical(32)
            LazyRow   (
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(Space16),
                contentPadding = PaddingValues(start = Space16),
            ) {
                items(state.hours) { hourlyData ->
                    WeatherTimeCard(time = hourlyData.hour, number = hourlyData.temp, icons = hourlyData.icons)
                }
            }
        }

    }

}