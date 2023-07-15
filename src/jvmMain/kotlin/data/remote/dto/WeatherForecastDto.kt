package data.remote.dto


import com.google.gson.annotations.SerializedName

data class WeatherForecastDto(
    @SerializedName("current")
    val current: Current?,
    @SerializedName("forecast")
    val forecast: Forecast?,
    @SerializedName("location")
    val location: Location?
)