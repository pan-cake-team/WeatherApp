package ui.screens.composable

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ui.theme.*


@Composable
fun WeatherTimeCard(
    modifier: Modifier = Modifier,
    icons: String,
    time: String,
    number: Int,
) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .height(208.dp)
            .width(104.dp)
            .background(Cards)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = time,
                style = typography.h4,
                color = TextSecondary,
            )
            SpacerVertical(8)
            HorizontalLine()
            SpacerVertical(8)
            IconSquare(icons = icons)
            SpacerVertical(8)
            Text(
                text = "$number °c",
                style = typography.h4,
                color = TextPrimary,
            )
        }
    }
}

@Preview
@Composable
fun PreviewWeatherTimeCard() {
}