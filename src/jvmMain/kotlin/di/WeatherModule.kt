package di


import data.remote.WeatherService
import data.remote.WeatherServiceImp
import data.repository.WeatherRepository
import data.repository.WeatherRepositoryImp
import data.util.HttpRoute
import domain.GetCurrentLocationUseCase
import domain.GetWeatherUseCase
import domain.SearchCityUseCase
import io.ktor.client.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import org.koin.core.Koin
import org.koin.dsl.module
import org.koin.core.context.startKoin
import ui.screens.MainViewModel


val weatherModule = module {


    single {
        HttpClient(Java) {
            install(ContentNegotiation) {
                gson()
            }
            defaultRequest {
                url(HttpRoute.BASE_URL)
            }
        }
    }

    single<WeatherService> { WeatherServiceImp(get()) }
    single<WeatherRepository> { WeatherRepositoryImp(get()) }
    single { GetWeatherUseCase()}
    single { GetCurrentLocationUseCase() }
    single { SearchCityUseCase() }
    single {MainViewModel()}


}

fun initKoin(): Koin {
    return startKoin {
        modules(modules = weatherModule)
    }.koin
}

