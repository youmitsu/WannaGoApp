package youmeee.co.jp.wannagoapp.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.graphics.Bitmap
import org.threeten.bp.LocalDate

/**
 * Created by yumitsuhori on 2018/07/01.
 */
@Entity(tableName = "items")
data class ItemEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val status: Int,
        val name: String,
        @ColumnInfo(name = "expected_date")
        val expectedDate: LocalDate,
        @ColumnInfo(name = "thumbnail_img")
        val thumbnailImg: Bitmap,
        @ColumnInfo(name = "thumbnail_url")
        val thumbnailUrl: String
)