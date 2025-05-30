package kan.kpo.newsapp.presentation.ui.auth.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kan.kpo.newsapp.theme.BluePrimary
import kan.kpo.newsapp.theme.GrayText
import kan.kpo.newsapp.theme.NewsAppTheme
import kan.kpo.newsapp.presentation.ui.GroupSocialButton
import kan.kpo.newsapp.presentation.ui.NewsAppTextField

@Composable
fun SignInScreen(
    viewModel: SignInViewModel,
    modifier: Modifier = Modifier

) {
    val username by viewModel.userName.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    var loading by remember { mutableStateOf(false) }
    var check by remember { mutableStateOf(false) }

    val uiState by viewModel.uiState.collectAsState()
    val userNameError by viewModel.userNameError.collectAsStateWithLifecycle()
    val passWordError by viewModel.passwordError.collectAsStateWithLifecycle()



        // ✅ เพิ่ม scroll ได้ ถ้าคีย์บอร์ดดันขึ้น
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .imePadding() // ✅ ทำให้ layout ดันตาม keyboard
                .verticalScroll(rememberScrollState()) // ✅ กัน layout ค้าง
        ) {
            Text(
                text = "Hello",
                fontWeight = FontWeight.Bold,
                fontSize = 42.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Again!",
                fontWeight = FontWeight.Bold,
                fontSize = 42.sp,
                color = BluePrimary,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Welcome back you've \nbeen missed!",
                fontSize = 18.sp,
                color = GrayText,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(32.dp))
            NewsAppTextField(
                onCheckedChange = { check = it },
                checked = check,
                onPasswordChange = viewModel::onPasswordChange,
                onUsernameChange = viewModel::onUserNameChange,
                password = password,
                username = username,
                isUsernameError = userNameError != null,
                isPasswordError = passWordError != null,
                errorUsernameMessage = userNameError,
                errorPasswordMessage = passWordError,

            )
            Spacer(modifier = Modifier.size(16.dp))
            GroupSocialButton(text = "Don't have an account?" )
        }

}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    NewsAppTheme {

    }

}