package kan.kpo.newsapp.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kan.kpo.newsapp.presentation.Screens


import kan.kpo.newsapp.theme.NewsAppTheme
import kan.kpo.newsapp.presentation.ui.auth.login.signup.SignUpScreen
import kan.kpo.newsapp.presentation.ui.auth.signin.SignInScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    Navigation(modifier = Modifier.padding(paddingValues))

                    SignUpScreen()
                }


            }

        }
    }
}

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.News
    ) {

        composable<Screens.News> {

        }
        composable<Screens.Article> { backStackEntry ->
            val article: Screens.Article = backStackEntry.toRoute()
            article.articleId



        }

        composable<Screens.SignUp> {

        }

         composable<Screens.Login> {

        }

    }


}
