package kan.kpo.newsapp.news.presentation.ui.auth.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlin.text.Typography.dagger


class SignInViewModel  : ViewModel() {
    private val _uiState = MutableStateFlow<SignInEvent>(SignInEvent.Nothing)
    var uiState = _uiState.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<SignInNavigationEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    private val _userName = MutableStateFlow("")
    val userName = _userName.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _userNameError = MutableStateFlow<String?>(null)
    val userNameError = _userNameError.asStateFlow()

    private val _passwordError = MutableStateFlow<String?>(null)
    val passwordError = _passwordError.asStateFlow()

    fun onUserNameChange(value: String) {
        _userName.value = value
        Log.d("SignInViewModel", "Username changed: $value")
        _userNameError.value = validateUsername(value)

    }

    fun onPasswordChange(value: String) {
        _password.value = value
        _passwordError.value = validatePassWord(value)

    }

    fun onSignInClick() {
        _uiState.value = SignInEvent.Loading

        _uiState.value = SignInEvent.Success
        _navigationEvent.tryEmit(SignInNavigationEvent.NavigatetoHome)

    }

    private fun validateUsername(username: String): String? {
        return when {
            username.isBlank() -> "Username is required"
            username.any { it.isWhitespace() } -> "Username must not contain spaces"
            else -> null

        }
    }

    private fun validatePassWord(password: String): String? {
        return when {
            password.isBlank() -> "Password is required"
            password.any { it.isWhitespace() } -> "Username must not contain spaces"
            password.length < 6 -> "Password must be at least 6 characters"

            else -> null

        }
    }



    sealed class SignInNavigationEvent {
        object NavigatetoHome : SignInNavigationEvent()
        object NavigatetoLogin : SignInNavigationEvent()

    }

    sealed class SignInEvent {
        object Nothing : SignInEvent()
        object Success : SignInEvent()
        object Error : SignInEvent()
        object Loading : SignInEvent()

    }


}