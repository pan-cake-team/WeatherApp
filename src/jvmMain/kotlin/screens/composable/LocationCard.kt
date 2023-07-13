package screens.composable

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import ui.theme.IconMap
import ui.theme.IconMapPointer
import ui.theme.Icons
import ui.theme.Radius8
import ui.theme.Space1
import ui.theme.Space12
import ui.theme.Space16
import ui.theme.Space32
import ui.theme.Space48
import ui.theme.Space8
import ui.theme.TextPrimary
import ui.theme.TextSecondary
import ui.theme.typography

@Composable
fun LocationCard(country: String, state: String) {
    Row(
        Modifier
            .clip(RoundedCornerShape(Radius8))
            .border(
                width = Space1, color = Icons, RoundedCornerShape(Radius8),
            )
            .fillMaxWidth()
            .height(Space48)
    ) {
        Row(Modifier.padding(horizontal = Space16, vertical = Space12).fillMaxWidth()) {
            Icon(painter = painterResource(IconMapPointer), null, tint = TextPrimary)
            Text(
                text = "$country,$state",
                style = typography.h6,
                color = TextPrimary,
                modifier = Modifier.padding(start = Space8)
            )
            Spacer(Modifier.weight(1f))
            HorizontalDivider()

            Icon(
                painter = painterResource(IconMap),
                null,
                tint = TextSecondary,
                modifier = Modifier.padding(start = Space8)
            )
        }


    }
}


@Preview
@Composable
private fun Preview() {
    LocationCard("Iraq", "Baghdad")

}