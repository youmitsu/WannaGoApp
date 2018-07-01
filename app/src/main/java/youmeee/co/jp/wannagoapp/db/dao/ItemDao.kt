package youmeee.co.jp.wannagoapp.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import youmeee.co.jp.wannagoapp.db.entity.ItemEntity

/**
 * ItemのDao
 */
@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createItem(itemEntity: ItemEntity)
}