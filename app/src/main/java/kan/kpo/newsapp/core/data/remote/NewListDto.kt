package kan.kpo.newsapp.core.data.remote

import kotlinx.serialization.Serializable


@Serializable
data class NewsListDto(
    val results: List<ArticleDto>?,
    val nextPage: String?,
)