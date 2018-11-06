package youmeee.co.jp.wannagoapp.repository

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import youmeee.co.jp.wannagoapp.db.dao.ItemDao
import youmeee.co.jp.wannagoapp.db.entity.ItemEntity

/**
 * Repository
 */
class ItemRepository(private val itemDao: ItemDao) {
    val allItems: LiveData<List<ItemEntity>> = itemDao.getAllItems()

    @WorkerThread
    suspend fun insert(itemEntity: ItemEntity) {
        itemDao.createItem(itemEntity)
    }
}
