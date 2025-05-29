package kan.kpo.newsapp.core.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(
    val article_id: String?,      // ID ของบทความ
    val title: String?,           // หัวข้อข่าว
    val description: String?,     // คำอธิบายสั้น
    val content: String?,         // เนื้อหาข่าวเต็ม
    val pubDate: String?,         // วันที่เผยแพร่ (เช่น "2025-05-24T12:00:00Z")
    val source_name: String?,     // ชื่อแหล่งข่าว เช่น "BBC"
    val image_url: String?        // URL ของรูปภาพประกอบ
)