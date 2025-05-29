package kan.kpo.newsapp.news.presentation

import kotlinx.serialization.Serializable

sealed interface Screens {

    @Serializable
    data object News : Screens

    @Serializable
    data class Article(val articleId: String) : Screens


    @Serializable
    data object Login : Screens

    @Serializable
    data object SignUp : Screens


    @Serializable
    data object ForgotPassword : Screens

    @Serializable
    data object DetailScreen : Screens

}