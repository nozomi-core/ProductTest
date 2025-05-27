package app.phoenixshell.productfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.phoenixshell.productfinder.model.Anything
import app.phoenixshell.productfinder.ui.theme.ProductFinderTheme
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //TODO:: Add this do dependancy injection
        val supabase = createSupabaseClient(
            supabaseUrl = "https://jnejpqphjplmyvprvryx.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImpuZWpwcXBoanBsbXl2cHJ2cnl4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDc4MDcxODMsImV4cCI6MjA2MzM4MzE4M30.jpFTEujc09Hp__EqS2S4muNRnn3fufwDYvkFgBZ-07M"
        ) {
            install(Postgrest)
            install(Auth)
        }

        setContent {
            ProductFinderTheme {
                LaunchedEffect(key1 = Unit) {
                    supabase.from("anything").insert(Anything("Welcome there"))
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProductFinderTheme {
        Greeting("Android")
    }
}