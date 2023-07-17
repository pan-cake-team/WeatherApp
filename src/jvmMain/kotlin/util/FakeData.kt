package util

import ui.theme.ImageClearSky
import ui.theme.ImageFoggy
import ui.theme.ImageMostlySunny
import ui.theme.ImageOverCast
import ui.theme.ImagePartlyCloudy
import ui.theme.ImageRaining
import ui.theme.ImageSnowing
import ui.theme.ImageThunder
import ui.theme.ImageWindy

val backgroundPath = mapOf<Int?, String>(
    1000 to ImageMostlySunny,
    1003 to ImagePartlyCloudy,
    1006 to ImagePartlyCloudy,
    1009 to ImageOverCast,
    1030 to ImageFoggy,
    1063 to "patchy rain possible",
    1066 to "Patchy snow possible",
    1069 to "Patchy sleet possible",
    1072 to "Patchy freezing drizzle possible",
    1087 to ImageThunder,
    1114 to ImageSnowing,
    1117 to "Blizzard",
    1135 to ImageFoggy,
    1147 to ImageFoggy,
    1150 to "Patchy light drizzle",
    1153 to "Light drizzle",
    1168 to "Freezing drizzle",
    1171 to "Heavy freezing drizzle",
    1180 to "patchy light rain",
    1183 to "Light rain",
    1186 to ImageRaining,
    1189 to ImageRaining,
    1192 to ImageRaining,
    1195 to ImageRaining,
    1198 to ImageRaining,
    1201 to ImageRaining,
    1204 to "light sleet",
    1207 to "Moderate or heavy sleet",
    1210 to ImageSnowing,
    1213 to ImageSnowing,
    1216 to ImageSnowing,
    1219 to ImageSnowing,
    1222 to ImageSnowing,
    1225 to "Ice pellets",
    1237 to ImageRaining,
    1240 to ImageRaining,
    1243 to ImageRaining,
    1246 to ImageRaining,
    1249 to "Light sleet showers",
    1252 to "Moderate or heavy sleet showers",
    1255 to ImageSnowing,
    1258 to ImageSnowing,
    1261 to ImageSnowing,
    1264 to ImageSnowing,
    1273 to ImageRaining,
    1276 to ImageRaining,
    1279 to ImageSnowing,
    1282 to ImageSnowing,
)
