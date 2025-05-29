package kan.kpo.newsapp.core.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kan.kpo.newsapp.core.data.domain.Article
import kan.kpo.newsapp.core.data.domain.NewList
import kan.kpo.newsapp.core.data.domain.NewsRepository
import kan.kpo.newsapp.core.data.domain.NewsResult
import kan.kpo.newsapp.core.data.local.ArtDicleDao
import kan.kpo.newsapp.core.data.remote.NewsListDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.cancellation.CancellationException

class NewsRepositoryImpl(
    private val httpClient: HttpClient,
    private val dao: ArtDicleDao,
) : NewsRepository {

    private val tag = "NewsRepositoryImpl"
    private val baseUrl = "http://newsdata.io/api/1/lastest"
    private val apiKey = "pub_a4c989e185d64304b5f223e944204d88"

    private suspend fun getLocalNews(nextPage: String?): NewList {
        val localNews = dao.getArticlesList()
        println(tag + "getLocalNews:" + localNews.size + "next Page: " + nextPage)

        val newsList = NewList(
            nextPage = nextPage,
            articles = localNews.map { it.toArticle() }
        )

        return newsList
    }

    private suspend fun getRemoteNews(nextPage: String?): NewList {
        val newsListDto: NewsListDto = httpClient.get(baseUrl) {
            parameter("apikey", apiKey)
            parameter("language", "en")
            if (nextPage != null) parameter("page", nextPage)

        }.body()
        println(tag + "getRemoteNews:" + newsListDto.results?.size + "next Page: " + nextPage)

        return newsListDto.toNewsList()
    }

    override suspend fun getNews(): Flow<NewsResult<NewList>> {
        return flow {
            val remoteNewsList = try {
                getRemoteNews(null)
            } catch (e: Exception) {
                e.printStackTrace()
                if(e is CancellationException) throw e
                println(tag + "getNews remote exception: " + e.message)
                null

            }

            remoteNewsList?.let {
                dao.clearDatabase()
                dao.upsertArticleList(remoteNewsList.articles.map { it.toArticleEntity() })
                emit(NewsResult.Success(getLocalNews(remoteNewsList.nextPage)))
                return@flow
            }

            val localNextList = getLocalNews(null)
            if (localNextList.articles.isNotEmpty()) {
                emit(NewsResult.Success(localNextList))
                return@flow
            }
            emit(NewsResult.Error("Something went wrong"))
        }
    }

    override suspend fun paginate(nextPage: String?): Flow<NewsResult<NewList>> {
        return flow {
            val remoteNewsList = try {
                getRemoteNews(nextPage)
            } catch (e: Exception) {
                e.printStackTrace()
                println(tag + "paginate remote exception: " + e.message)
                null

            }

            remoteNewsList?.let {
                dao.upsertArticleList(remoteNewsList.articles.map { it.toArticleEntity() })

                //not getting them from the database like getNews()
                //because we will also get old items that we already have before paginate
                emit(NewsResult.Success(remoteNewsList))
                return@flow
            }


        }
    }

//    override suspend fun getArticle(articleId: String): Flow<NewsResult<Article>> {
//        TODO("Not yet implemented")
//    }
}