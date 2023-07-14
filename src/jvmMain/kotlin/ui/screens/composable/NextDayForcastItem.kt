package ui.screens.composable

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import ui.theme.Divider
import ui.theme.IconCloudRaining
import ui.theme.IconsSurface
import ui.theme.Radius8
import ui.theme.Space16
import ui.theme.Space8
import ui.theme.TextPrimary
import ui.theme.TextSecondary
import ui.theme.typography

@Composable
fun NextDayForCastItem() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(Radius8))
            .border(width = 1.dp, color = Divider, shape = RoundedCornerShape(Radius8))

    ) {
        Row(
            modifier = Modifier
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
                    painter = painterResource(IconCloudRaining),
                    contentDescription = null,
                    tint = Color.White

                )

            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(start = Space8, end = Space16)
            ) {
                Text(text = "Tuesday,Oct 28", style = typography.h5, color = TextPrimary)
                Text(text = "Heavy Rain", style = typography.h6, color = TextSecondary)
            }
            HorizontalDivider()

            Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier) {
                Text("11°", style = typography.h5, color = TextPrimary)
                Text("3°", style = typography.h6, color = TextSecondary)
            }
        }
    }

}

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.background(Color.Black).fillMaxSize()) {
        NextDayForCastItem()
    }
}