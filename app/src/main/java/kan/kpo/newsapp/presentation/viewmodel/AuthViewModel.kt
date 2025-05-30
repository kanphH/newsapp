package kan.kpo.newsapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kan.kpo.newsapp.auth.repository.AuthRepository
import kan.kpo.newsapp.presentation.ui.auth.AuthUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: AuthRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()


    fun signUp(username: String, password: String,) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val result = authRepository.signUp(username = username, password = password)

            if (result != null){
                val firebaseUser = result.user
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    user = firebaseUser,
                    errorMessage = null,
                    isSignedIn = firebaseUser != null
                )
            } else {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = "สมัครสมาชิกไม่สำเร็จ"
                )

            }

        }

    }

    fun signIn(username: String, password: String, )  {

    }

    fun signOut(username: String, password: String) {

    }

}


