package kan.kpo.newsapp.presentation.ui.auth

import com.google.firebase.auth.FirebaseUser

data class AuthUiState(
    val isLoading: Boolean = false,
    val user: FirebaseUser? = null,
    val errorMessage: String? = null,
    val isSignedIn: Boolean = false,
    val error: String? = null
)
