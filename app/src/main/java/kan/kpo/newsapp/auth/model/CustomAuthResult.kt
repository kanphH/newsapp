package kan.kpo.newsapp.auth.model

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.auth.AdditionalUserInfo
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

data class CustomAuthResult(
    val user: User?,
    val isSuccessful: Boolean,
    val errorMessage: String? = null

) : AuthResult {
    constructor(parcel: Parcel) : this(
        TODO("user"),
        parcel.readByte() != 0.toByte(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    override fun getAdditionalUserInfo(): AdditionalUserInfo? {
        TODO("Not yet implemented")
    }

    override fun getCredential(): AuthCredential? {
        TODO("Not yet implemented")
    }

    override fun getUser(): FirebaseUser? {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<AuthResult> {
        override fun createFromParcel(parcel: Parcel): AuthResult {
            return CustomAuthResult(parcel)
        }

        override fun newArray(size: Int): Array<AuthResult?> {
            return arrayOfNulls(size)
        }
    }
}
