package di

import data.remote.WeatherService
import data.remote.WeatherServiceImp
import data.repo.WeatherRepo
import data.repo.WeatherRepoImpl
import org.koin.dsl.module


val weatherModule = module {

    single<WeatherService> { WeatherServiceImp(get()) }
    single<WeatherRepo> { WeatherRepoImpl(get()) }

}