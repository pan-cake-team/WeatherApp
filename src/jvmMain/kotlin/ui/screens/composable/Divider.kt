package ui.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.theme.Divider
import ui.theme.Space2

@Composable
fun HorizontalDivider(modifier: Modifier=Modifier) {
    Spacer(
        modifier.width(Space2).fillMaxHeight().background(Divider)
    )
}

@Composable
fun VerticalDivider(){
    Spacer(
        Modifier.fillMaxWidth().height(Space2).background(Divider)
    )
}