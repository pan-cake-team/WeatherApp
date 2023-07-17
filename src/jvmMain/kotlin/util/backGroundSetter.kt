package util

import ui.theme.ImageFoggy
import ui.theme.ImageMostlySunny
import ui.theme.ImageOverCast
import ui.theme.ImagePartlyCloudy
import ui.theme.ImageRaining
import ui.theme.ImageSnowing
import ui.theme.ImageThunder
import ui.theme.ImageWindy

fun setBackground(code: Int?): String {
    return backgroundPath.getValue(code) ?: ImageMostlySunny
}

val backgroundPath = mapOf<Int?, String>(
    1000 to ImageMostlySunny,
    1003 to ImagePartlyCloudy,
    1006 to ImagePartlyCloudy,
    1009 to ImageOverCast,
    1030 to ImageFoggy,
    1063 to ImageRaining,
    1066 to ImageSnowing,
    1069 to ImageRaining,
    1072 to ImageSnowing,
    1087 to ImageThunder,
    1114 to ImageSnowing,
    1117 to ImageWindy,
    1135 to ImageFoggy,
    1147 to ImageFoggy,
    1150 to ImageRaining,
    1153 to ImageRaining,
    1168 to ImageRaining,
    1171 to ImageRaining,
    1180 to ImageRaining,
    1183 to ImageRaining,
    1186 to ImageRaining,
    1189 to ImageRaining,
    1192 to ImageRaining,
    1195 to ImageRaining,
    1198 to ImageRaining,
    1201 to ImageRaining,
    1204 to ImageRaining,
    1207 to ImageRaining,
    1210 to ImageSnowing,
    1213 to ImageSnowing,
    1216 to ImageSnowing,
    1219 to ImageSnowing,
    1222 to ImageSnowing,
    1225 to ImageSnowing,
    1237 to ImageRaining,
    1240 to ImageRaining,
    1243 to ImageRaining,
    1246 to ImageRaining,
    1249 to ImageSnowing,
    1252 to ImageSnowing,
    1255 to ImageSnowing,
    1258 to ImageSnowing,
    1261 to ImageSnowing,
    1264 to ImageSnowing,
    1273 to ImageRaining,
    1276 to ImageRaining,
    1279 to ImageSnowing,
    1282 to ImageSnowing,
)
