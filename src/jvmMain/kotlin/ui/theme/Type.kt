package ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import fontResources

@Composable
private fun CustomTypography() = Typography(
    defaultFontFamily = FontFamily(
        fontResources("aeonik_regular.otf", FontWeight.Normal, FontStyle.Normal),
        fontResources("aeonik_medium.otf", FontWeight.W500, FontStyle.Normal),
        fontResources("aeonik_bold.otf", FontWeight.Bold, FontStyle.Normal)
    )
)
private val Poppins =  FontFamily(
    fontResources("poppins_regular.ttf", FontWeight.Normal, FontStyle.Normal),
    fontResources("poppins_semi_bold.ttf", FontWeight.SemiBold, FontStyle.Normal),
)

@Composable
fun ApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = typography,
        content = content
    )
}

val typography = Typography(
    //text small
    h6 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = textSize16,
    ),

    //text normal
    h5 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = textSize16,
    ),

    //text medium
    h4 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = textSize24,
    ),

    //text title
    h3 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = textSize24,
    ),

    //text large
    h2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = textSize80,
    ),

    //text huge
    h1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = textSize128,
    ),
)