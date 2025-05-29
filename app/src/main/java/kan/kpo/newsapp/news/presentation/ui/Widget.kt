package kan.kpo.newsapp.news.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kan.kpo.newsapp.R

import kan.kpo.newsapp.news.presentation.theme.BluePrimary
import kan.kpo.newsapp.news.presentation.theme.CyanText
import kan.kpo.newsapp.news.presentation.theme.NewsAppTheme

@Composable
fun GroupSocialButton(
    modifier: Modifier = Modifier,
    text: String,
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SocialButton(
                icon = R.drawable.ic_facebook,
                title = "Facebook",
                onClick = {}
            )
            SocialButton(
                icon = R.drawable.ic_google,
                title = "Google",
                onClick = {}
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row {
            Text(text = text)
            Spacer(modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "Sign up",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { },
                style = MaterialTheme.typography.titleMedium
            )

        }

    }


}

@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = icon), contentDescription = null)
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.SemiBold
            )


        }

    }


}


@Composable
fun NewsAppTextField(
    username: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    isUsernameError: Boolean = false,
    isPasswordError: Boolean = false,
    errorUsernameMessage: String? = null,
    errorPasswordMessage: String? = null,



    ) {

    var passwordVisible by remember { mutableStateOf(false) }


    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Username", style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        OutlinedTextField(
            value = username, onValueChange = onUsernameChange,
            modifier = Modifier.fillMaxWidth().focusable(),
            isError = isUsernameError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )

        )
        if (isUsernameError) {
            Text(
                text = errorUsernameMessage ?: "",
                color = MaterialTheme.colorScheme.error
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "Password",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(vertical = 4.dp)

        )
        OutlinedTextField(
            value = password, onValueChange = onPasswordChange,
            modifier = Modifier.fillMaxWidth(),
            isError = isPasswordError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_eye),
                        contentDescription = null
                    )

                }
            },
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else
                PasswordVisualTransformation()

        )
        if (isPasswordError) {
            Text(
                text = errorPasswordMessage ?: "",
                color = MaterialTheme.colorScheme.error
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                modifier = Modifier.size(25.dp),
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = CheckboxDefaults.colors(checkedColor = BluePrimary),
            )
            Spacer(modifier = Modifier.size(4.dp))

            Text(
                text = "Remember me", style = MaterialTheme.typography.bodySmall,
                fontSize = 14.sp,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "Forget Password?", style = MaterialTheme.typography.bodySmall,
                fontSize = 14.sp,
                color = CyanText,
                modifier = Modifier.clickable {

                }
            )
        }
        Spacer(modifier = Modifier.size(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Login", style = MaterialTheme.typography.titleMedium,
            )

        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "or continue with", modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodySmall,
            fontSize = 14.sp
        )


    }


}


@Preview(showBackground = true)
@Composable
private fun GroupSocialButtonPreview() {
    NewsAppTheme {

    }

}