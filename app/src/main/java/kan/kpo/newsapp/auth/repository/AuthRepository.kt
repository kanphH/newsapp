package kan.kpo.newsapp.auth.repository

import com.google.firebase.auth.AuthResult

interface AuthRepository {
    suspend fun signUp(username: String, password: String): AuthResult
    suspend fun signIn(username: String, password: String): AuthResult?
    suspend fun signOut(): Boolean
    fun isUserLoggedIn(): Boolean

}