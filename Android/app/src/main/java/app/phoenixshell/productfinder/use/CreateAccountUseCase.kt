package app.phoenixshell.productfinder.use

import app.phoenixshell.productfinder.lang.tryOutcome
import app.phoenixshell.productfinder.model.AccountInfo
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class CreateAccountUseCase(private val client: SupabaseClient) {
    suspend fun execute(email: String, password: String) = tryOutcome {
        client.auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }?.let { result ->
            AccountInfo()
        }
    }
}