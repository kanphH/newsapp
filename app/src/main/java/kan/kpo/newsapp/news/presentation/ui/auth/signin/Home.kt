package kan.kpo.newsapp.news.presentation.ui.auth.signin

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kan.kpo.newsapp.R


@Composable
fun Home(modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null )

}

@Preview
@Composable
private fun prevss() {
    Home()


}