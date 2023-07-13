package di

import data.remote.WeatherService
import data.remote.WeatherServiceImp
import data.repository.WeatherRepository
import data.repository.WeatherRepositoryImp
import org.koin.dsl.module


val weatherModule = module {
    single<WeatherService> { WeatherServiceImp(get()) }
    single<WeatherRepository> { WeatherRepositoryImp(get()) }

}