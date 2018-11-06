package youmeee.co.jp.wannagoapp.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by yumitsuhori on 2018/07/01.
 */
@Entity(tableName = "items")
data class ItemEntity(
        @PrimaryKey
        val id: Int,
        val status: Int,
        val name: String,
        @ColumnInfo(name = "thumbnail_url")
        val thumbnailUrl: String
)