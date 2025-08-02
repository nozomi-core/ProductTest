package app.phoenixshell.productfinder.di

import app.phoenixshell.productfinder.feature.account.CreateAccountViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CreateAccountViewModel() }
}