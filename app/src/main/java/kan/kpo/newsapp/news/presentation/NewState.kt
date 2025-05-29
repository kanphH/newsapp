package kan.kpo.newsapp.news.presentation

import kan.kpo.newsapp.core.data.domain.Article

data class NewState(
    val articleList: List<Article> = emptyList(),
    val nextPage: String? = null,
    val isLoading : Boolean = false,
    val isError : Boolean = false
)