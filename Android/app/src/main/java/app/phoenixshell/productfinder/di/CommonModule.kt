package app.phoenixshell.productfinder.di

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.dsl.module

val commonModule = module {

    single<SupabaseClient> {
        createSupabaseClient(
            supabaseUrl = "https://jnejpqphjplmyvprvryx.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImpuZWpwcXBoanBsbXl2cHJ2cnl4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDc4MDcxODMsImV4cCI6MjA2MzM4MzE4M30.jpFTEujc09Hp__EqS2S4muNRnn3fufwDYvkFgBZ-07M"
        ) {
            install(Postgrest)
            install(Auth)
        }
    }
}