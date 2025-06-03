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
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.koin.compose.koinInject
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val supabase = koinInject<SupabaseClient>()

            ProductFinderTheme {
                LaunchedEffect(key1 = Unit) {
                    supabase.from("anything").insert(Anything("The GI", BigDecimal("98.2")))
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