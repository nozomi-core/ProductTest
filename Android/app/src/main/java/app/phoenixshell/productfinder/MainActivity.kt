package app.phoenixshell.productfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.phoenixshell.productfinder.core.Route
import app.phoenixshell.productfinder.feature.splash.SplashScreenRoot
import app.phoenixshell.productfinder.feature.account.CreateAccountRoot
import app.phoenixshell.productfinder.feature.develop.DevelopScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Route.Develop) {
                composable<Route.Develop> {
                    DevelopScreen(navController)
                }

                composable<Route.Splash> {
                    SplashScreenRoot(navController)
                }
                composable<Route.CreateAccount> {
                    CreateAccountRoot(navController)
                }
            }
        }
    }
}