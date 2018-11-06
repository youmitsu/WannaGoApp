package youmeee.co.jp.wannagoapp.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import youmeee.co.jp.wannagoapp.db.entity.ItemEntity

/**
 * ItemのDao
 */
@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createItem(itemEntity: ItemEntity)

    @Query("SELECT * FROM items")
    fun getAllItems(): LiveData<List<ItemEntity>>

    @Query("DELETE FROM items")
    fun deleteAll()
}