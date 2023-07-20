package ui.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.Divider

@Composable
fun HorizontalLine(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier
        .height(1.dp)
        .padding(start = 40.dp, end = 40.dp)
        .background(Divider)
        .fillMaxWidth()
    )
}