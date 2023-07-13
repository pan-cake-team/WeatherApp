package screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import screens.composable.LocationCard
import screens.composable.NextDayForCastItem
import ui.theme.*

@Composable
fun RightSide() {
    Box(Modifier.fillMaxHeight().background(color = Cards)) {

        Column(
            modifier = Modifier.width(Space360),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.fillMaxWidth().padding(start = Space32, end = Space32, top = Space40)){
                LocationCard(country = "Iraq", state = "Baghdad")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("11°", style = typography.h1, color = TextPrimary)
                Text(
                    "c",
                    style = typography.subtitle1,
                    color = TextPrimary,
                    modifier = Modifier
                )
            }
            Box {
                Row(Modifier.padding(Space8)) {
                    Icon(painter = painterResource(IconSun), null, tint = TextSecondary)
                    Text(
                        modifier = Modifier.padding(start = Space8),
                        text = "Lower temperature, 5°c",
                        style = typography.h6,
                        color = TextPrimary
                    )
                }
            }
            Box(Modifier.padding(top = Space8)) {
                Row(Modifier.padding(Space8)) {
                    Icon(painter = painterResource(IconWind), null, tint = TextSecondary)
                    Text(
                        modifier = Modifier.padding(start = Space8),
                        text = "Wind speed, 2 km/h",
                        style = typography.h6,
                        color = TextPrimary
                    )
                }
            }
            Box(Modifier.padding(top = Space8, bottom = Space40)) {
                Row(Modifier.padding(Space8)) {
                    Icon(painter = painterResource(IconWaterDrops), null, tint = TextSecondary)
                    Text(
                        modifier = Modifier.padding(start = Space8),
                        text = "Precipitation, 2%",
                        style = typography.h6,
                        color = TextPrimary
                    )
                }
            }

            Spacer(Modifier.padding(horizontal = Space32).fillMaxWidth().height(Space1).background(Divider))
            Column(
                Modifier.fillMaxHeight()
                    .padding( top = Space40),
                verticalArrangement = Arrangement.spacedBy(space = Space24),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("The Next Day Forcast", style = typography.h4, color = TextPrimary)
                LazyColumn(
                    contentPadding = PaddingValues(Space8),
                    verticalArrangement = Arrangement.spacedBy(Space16),
                    modifier = Modifier
                ) {
                    items(count = 4) {
                        NextDayForCastItem()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {

    RightSide()
}