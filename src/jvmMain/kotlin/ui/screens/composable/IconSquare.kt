package ui.screens.composable

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ui.theme.Icons
import ui.theme.IconsSurface

@Composable
fun IconSquare(
    icons: String,
) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .size(75.dp)
            .background(IconsSurface)
    ) {

        Icon(
            modifier = Modifier

                .size(40.dp)
                .align(Alignment.Center),
            painter = painterResource(icons),
            contentDescription = "Cloud Rain Icon",
            tint = Icons,
        )
    }
}


@Composable
@Preview
fun PreviewIconSquare() {

}