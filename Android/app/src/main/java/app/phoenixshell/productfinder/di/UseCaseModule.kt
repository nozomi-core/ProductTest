package app.phoenixshell.productfinder.di

import app.phoenixshell.productfinder.use.AddProductPriceHistoryUseCase
import app.phoenixshell.productfinder.use.CreateAccountUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { AddProductPriceHistoryUseCase() }
    factory { CreateAccountUseCase(get()) }
}