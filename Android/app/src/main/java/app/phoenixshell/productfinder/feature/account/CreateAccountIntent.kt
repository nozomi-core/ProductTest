package app.phoenixshell.productfinder.feature.account

sealed interface CreateAccountIntent {
    class UpdateEmail(val email: String): CreateAccountIntent
}