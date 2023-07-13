package screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import screens.composable.HorizontalLine
import screens.composable.SpacerVertical
import screens.composable.WeatherTimeCard
import ui.theme.TextSecondary
import ui.theme.typography


@Composable
fun MainScreen() {

    MainContent()
}

@Composable
fun MainContent(){

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
            Column(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(40.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End,
            ) {

                Text("Mist", style = typography.h1, color = TextSecondary)
                HorizontalLine()
                SpacerVertical(32)
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(start = 16.dp),
                ) {
                    items(8) {
                        WeatherTimeCard(time = "11:00", number = 12,)
                    }
                }
            }

            RightSide()

        }
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    MainScreen()
}