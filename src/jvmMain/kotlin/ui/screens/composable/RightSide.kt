package ui.screens.composable

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import kotlinx.coroutines.delay
import org.koin.core.component.getScopeId
import ui.screens.DaysInterval
import ui.screens.MainUIState
import ui.theme.*

@Composable
fun RightSide(
    state: MainUIState,
    onWeatherDayItemClicked: (DaysInterval) -> Unit,
    search: (searchText: String) -> Unit,
    onSearchIconClick: () -> Unit,
) {

    var searchText by rememberSaveable { mutableStateOf("") }
    LaunchedEffect(searchText) {
        delay(1000)
        search(searchText)
    }
    Box(Modifier.fillMaxHeight().background(color = Cards)) {

        Column(
            modifier = Modifier.width(Space360),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.fillMaxWidth().padding(start = Space32, end = Space32, top = Space40)) {
                if (state.isSearching) {
                    TextField(
                        value = searchText,
                        onValueChange = { newString ->
                            searchText = newString
                        },
                        textStyle = typography.h5,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            cursorColor = Color.White,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Text  // Add this line
                        ),
                        singleLine = true,  // Add this line
                        keyboardActions = KeyboardActions(
                            onDone = { search(searchText) }
                        ),
                    )
                } else {
                    LocationCard(country = state.location, onSearchIconClick)
                    searchText = ""
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("${state.todayTemp}°", style = typography.h1, color = TextPrimary)
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
                        text = "Lower temperature, ${state.todayMinTemp}°c",
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
                        text = "Wind speed, ${state.windSpeed} km/h",
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
                        text = "Precipitation, ${state.precipitation}%",
                        style = typography.h6,
                        color = TextPrimary
                    )
                }
            }

            Spacer(
                Modifier.padding(horizontal = Space32).fillMaxWidth().height(Space1)
                    .background(Divider)
            )
            Column(
                Modifier.fillMaxHeight()
                    .padding(top = Space40),
                verticalArrangement = Arrangement.spacedBy(space = Space24),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("The Next Day Forcast", style = typography.h4, color = TextPrimary)
                LazyColumn(
                    contentPadding = PaddingValues(Space8),
                    verticalArrangement = Arrangement.spacedBy(Space16),
                    modifier = Modifier
                ) {
                    items(state.days) { daysData ->
                        NextDayForCastItem(
                            daysInterval = daysData,
                            onWeatherDayItemClicked = onWeatherDayItemClicked,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {

//    RightSide()
}