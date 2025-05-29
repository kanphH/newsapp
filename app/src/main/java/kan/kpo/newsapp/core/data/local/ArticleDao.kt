package kan.kpo.newsapp.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ArtDicleDao {
    @Query("SELECT * FROM articleentity")
    suspend fun getArticlesList(): List<ArticleEntity>

    @Upsert
    suspend fun upsertArticleList(articleList : List<ArticleEntity>)

    @Query("SELECT * FROM articleentity WHERE articleId = :articleId")
    suspend fun getArticle(articleId :String): ArticleEntity?

    @Query("DELETE FROM articleentity")
    suspend fun clearDatabase()
}