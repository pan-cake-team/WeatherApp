package di

import data.remote.WeatherService
import data.remote.WeatherServiceImp
import data.repository.WeatherRepository
import data.repository.WeatherRepositoryImp
import domain.GetCityLocationUseCase
import domain.GetCurrentLocationUseCase
import domain.GetDailyWeatherUseCase
import domain.GetHourlyWeatherUseCase
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.Koin
import org.koin.dsl.module
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import ui.screens.left_side.HourlySideViewModel
import ui.screens.right_side.DailySideViewModel
import org.koin.core.module.dsl.bind


val weatherModule = module {
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                }
                )
            }
        }
    }
    singleOf(::WeatherServiceImp) { bind<WeatherService>() }
    singleOf(::WeatherRepositoryImp) { bind<WeatherRepository>() }
    single { GetDailyWeatherUseCase(get(), get()) }
    single { GetHourlyWeatherUseCase(get(), get()) }
    single { GetCurrentLocationUseCase(get()) }
    single {DailySideViewModel()}
    single {HourlySideViewModel()}
    single { GetCityLocationUseCase(get()) }


}

fun initKoin(): Koin {
    return startKoin {
        modules(modules = weatherModule)
    }.koin
}

