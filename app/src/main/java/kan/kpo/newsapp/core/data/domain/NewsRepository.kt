package kan.kpo.newsapp.core.data.domain

import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow

interface NewsRepository {


    suspend fun getNews(): Flow<NewsResult<NewList>>
    suspend fun paginate(nextPage: String?): Flow<NewsResult<NewList>>
//    suspend fun getArticle(articleId: String): Flow<NewsResult<Article>>
}