package di

import data.remote.WeatherService
import data.remote.WeatherServiceImp
import data.repository.WeatherRepository
import data.repository.WeatherRepositoryImp
import domain.GetCurrentLocationUseCase
import domain.GetDailyWeatherUseCase
import domain.GetHourlyWeatherUseCase
import org.koin.dsl.module


val weatherModule = module {
    single<WeatherService> { WeatherServiceImp(get()) }
    single<WeatherRepository> { WeatherRepositoryImp(get()) }
    single { GetDailyWeatherUseCase(get()) }
    single { GetHourlyWeatherUseCase(get()) }
    single { GetCurrentLocationUseCase(get()) }
}