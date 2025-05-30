package kan.kpo.newsapp.presentation.ui.auth.login.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kan.kpo.newsapp.theme.BluePrimary
import kan.kpo.newsapp.theme.GrayText
import kan.kpo.newsapp.theme.NewsAppTheme
import kan.kpo.newsapp.presentation.ui.GroupSocialButton
import kan.kpo.newsapp.presentation.ui.NewsAppTextField

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {


    Box(modifier = modifier.padding(24.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()


        ) {
            Text(
                text = "Hello",
                fontWeight = FontWeight.Bold,
                fontSize = 42.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Signup to get Started!",
                fontSize = 18.sp,
                color = GrayText,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(32.dp))
            NewsAppTextField(
                onCheckedChange = {},
                checked = true,
                onPasswordChange = {},
                onUsernameChange = {},
                password = "",
                username = ""
            )
            Spacer(modifier = Modifier.size(16.dp))
            GroupSocialButton(text = "Already have an account?")


        }
    }

}


@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    NewsAppTheme {
        SignUpScreen()
    }

}