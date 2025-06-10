package app.phoenixshell.productfinder.core

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object CreateAccount
    @Serializable
    data object Login
    @Serializable
    data object Develop
    @Serializable
    data object Splash
}