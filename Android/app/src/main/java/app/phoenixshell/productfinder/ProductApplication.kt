package app.phoenixshell.productfinder

import android.app.Application
import app.phoenixshell.productfinder.di.commonModule
import app.phoenixshell.productfinder.di.useCaseModule
import org.koin.core.context.startKoin

class ProductApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(commonModule, useCaseModule)
        }
    }
}