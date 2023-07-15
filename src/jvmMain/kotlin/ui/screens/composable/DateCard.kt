package ui.screens.composable

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ui.screens.MainUIState
import ui.theme.Cards
import ui.theme.TextSecondary
import ui.theme.typography

@Composable
fun DateCard(
    state: MainUIState,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Cards)

    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            text = state.date,
            style = typography.h3,
            color = TextSecondary,
        )
    }
}

@Preview
@Composable
fun PreviewCard() {

}