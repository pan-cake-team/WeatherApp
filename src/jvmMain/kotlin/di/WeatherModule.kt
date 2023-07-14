package di

import data.remote.WeatherService
import data.remote.WeatherServiceImp
import data.repository.WeatherRepository
import data.repository.WeatherRepositoryImp
import domain.GetCityLocationUseCase
import domain.GetCurrentLocationUseCase

import domain.GetHourlyWeatherUseCase
import org.koin.core.Koin
import org.koin.dsl.module
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.bind
import ui.screens.MainViewModel


val weatherModule = module {

    singleOf(::WeatherServiceImp) { bind<WeatherService>() }
    singleOf(::WeatherRepositoryImp) { bind<WeatherRepository>() }
//    single { GetDailyWeatherUseCase(get(), get()) }
    single { GetHourlyWeatherUseCase(get(), get()) }
    single { GetCurrentLocationUseCase(get()) }
    single {MainViewModel()}
    single { GetCityLocationUseCase(get()) }


}

fun initKoin(): Koin {
    return startKoin {
        modules(modules = weatherModule)
    }.koin
}

