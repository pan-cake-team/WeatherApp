package screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import screens.composable.LocationCard
import screens.composable.NextDayForCastItem
import ui.theme.Cards
import ui.theme.Divider
import ui.theme.IconSun
import ui.theme.IconWaterDrops
import ui.theme.IconWind
import ui.theme.ImageThunder
import ui.theme.Space1
import ui.theme.Space16
import ui.theme.Space2
import ui.theme.Space24
import ui.theme.Space32
import ui.theme.Space40
import ui.theme.Space8
import ui.theme.TextPrimary
import ui.theme.TextSecondary
import ui.theme.typography

@Composable
fun RightSide() {
    Box(Modifier.fillMaxHeight().background(color = Cards)) {

        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = Space32),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocationCard(country = "Iraq", state = "Baghdad")
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

            Spacer(Modifier.fillMaxWidth().height(Space1).background(Divider))
            Column(
                Modifier.fillMaxHeight()
                    .background(color = Cards)
                    .padding(start = Space32, end = Space32, top = Space40),
                verticalArrangement = Arrangement.spacedBy(space = Space24),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("The Next Day Forcast", style = typography.h4, color = TextPrimary)
                LazyColumn(
                    contentPadding = PaddingValues(Space8),
                    verticalArrangement = Arrangement.spacedBy(Space16),
                    modifier = Modifier.padding(horizontal = Space32)
                ) {
                    items(count = 40) {
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