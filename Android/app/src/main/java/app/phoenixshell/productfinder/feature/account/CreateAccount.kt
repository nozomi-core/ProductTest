package app.phoenixshell.productfinder.feature.account

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.compose.viewmodel.koinViewModel
import app.phoenixshell.productfinder.feature.account.CreateAccountIntent.*

@Composable
fun CreateAccountRoot(navController: NavController, viewModel: CreateAccountViewModel = koinViewModel()) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    CreateAccountScreen(uiState, viewModel::sendIntent)
}

@Composable
fun CreateAccountScreen(state: CreateAccountState, sendIntent: (CreateAccountIntent) -> Unit) {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

            TextField(
                value = state.email,
                onValueChange = {
                    sendIntent(UpdateEmail(it))
                },
                placeholder = {
                    Text("Email")
                }
            )
        }
    }
}