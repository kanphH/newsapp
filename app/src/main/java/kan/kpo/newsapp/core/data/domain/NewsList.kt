package kan.kpo.newsapp.core.data.domain

import kan.kpo.newsapp.core.data.remote.ArticleDto
import kotlinx.serialization.Serializable


data class NewList(
    val nextPage: String?,
    val articles: List<Article>,
)