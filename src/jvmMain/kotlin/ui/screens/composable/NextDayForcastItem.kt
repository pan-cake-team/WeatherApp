package ui.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ui.screens.DaysInterval
import ui.theme.Divider
import ui.theme.IconsSurface
import ui.theme.Radius8
import ui.theme.Space16
import ui.theme.Space8
import ui.theme.TextPrimary
import ui.theme.TextSecondary
import ui.theme.typography

@Composable
fun NextDayForCastItem(
    daysInterval: DaysInterval,
    onWeatherDayItemClicked: (DaysInterval) -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(Radius8))
            .border(width = 1.dp, color = Divider, shape = RoundedCornerShape(Radius8))
            .clickable { onWeatherDayItemClicked(daysInterval) }

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = Space8, bottom = Space8, start = Space8, end = Space16,
                ),
        ) {

            Box(
                modifier = Modifier.background(
                    color = IconsSurface, RoundedCornerShape(Radius8),
                ),
            ) {
                Icon(
                    modifier = Modifier.padding(Space8).size(40.dp),
                    painter = painterResource(daysInterval.icons),
                    contentDescription = null,
                    tint = Color.White

                )

            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(start = Space8, end = Space16)
            ) {
                Text(text = daysInterval.date, style = typography.h5, color = TextPrimary)
                Text(text = daysInterval.weatherType, style = typography.h6, color = TextSecondary)
            }
            Spacer(modifier = Modifier.weight(1f))
            HorizontalDivider()

            Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier) {
                Text("${daysInterval.maxTemp}°", style = typography.h5, color = TextPrimary)
                Text("${daysInterval.minTemp}°", style = typography.h6, color = TextSecondary)
            }
        }
    }

}

