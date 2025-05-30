import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kan.kpo.newsapp.auth.model.CustomAuthResult
import kan.kpo.newsapp.auth.model.User
import kan.kpo.newsapp.auth.repository.AuthRepository
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepositoryImpl : AuthRepository {

    private val auth = FirebaseAuth.getInstance()

    override suspend fun signUp(username: String, password: String): AuthResult {
        return try {
            val result = auth.createUserWithEmailAndPassword(username, password).await()
            val firebaseUser = result.user
            if (firebaseUser != null) {
                val user = User(
                    uid = firebaseUser.uid,
                    username = firebaseUser.displayName,

                )
                CustomAuthResult(user = user, isSuccessful = true)
            } else {
                CustomAuthResult(
                    user = null,
                    isSuccessful = false,
                    errorMessage = "สร้างบัญชีไม่สำเร็จ"
                )
            }
        } catch (e: FirebaseAuthException) {
            val errorMessage = when (e.errorCode) {
                "ERROR_EMAIL_ALREADY_IN_USE" -> "อีเมลนี้ถูกใช้งานแล้ว"
                "ERROR_WEAK_PASSWORD" -> "รหัสผ่านไม่ปลอดภัย"
                "ERROR_INVALID_EMAIL" -> "รูปแบบอีเมลไม่ถูกต้อง"
                else -> e.localizedMessage ?: "เกิดข้อผิดพลาด"
            }
            CustomAuthResult(user = null, isSuccessful = false, errorMessage = errorMessage)

        }
    }

    override suspend fun signIn(username: String, password: String): AuthResult? {
        return try {
            auth.signInWithEmailAndPassword(username, password).await()
        } catch (e: Exception) {
            null
        }
    }


    override suspend fun signOut(): Boolean {
        return try {
            auth.signOut()
            true
        } catch (e: Exception) {
            false
        }
    }


    override fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }
}