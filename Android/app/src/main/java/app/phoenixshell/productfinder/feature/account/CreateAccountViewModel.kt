package app.phoenixshell.productfinder.feature.account

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CreateAccountViewModel: ViewModel() {
    private val _state = MutableStateFlow(CreateAccountState())
    val state = _state.asStateFlow()

    fun sendIntent(createAccountIntent: CreateAccountIntent) {

    }
}