package youmeee.co.jp.wannagoapp.repository

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import youmeee.co.jp.wannagoapp.db.dao.ItemDao
import youmeee.co.jp.wannagoapp.db.entity.ItemEntity
import youmeee.co.jp.wannagoapp.net.FirestoreClient

/**
 * Repository
 */
class ItemRepository(
        private val itemDao: ItemDao,
        private val firestoreClient: FirestoreClient) {
    private val TABLE_NAME_PLACE = "place"

    val allItems: LiveData<List<ItemEntity>> = itemDao.getAllItems()
    val allPlaces: MutableList<Map<String, Any>> = mutableListOf()

    @WorkerThread
    suspend fun insert(itemEntity: ItemEntity) {
        itemDao.createItem(itemEntity)
    }

    @WorkerThread
    suspend fun insertPlaces() {
        val place = mapOf<String, Any>(Pair("name", "hoge"), Pair("expected", "hoge"))
        firestoreClient.insertItem(TABLE_NAME_PLACE, place, {}, {})
    }

    suspend fun getAllPlaces() {
        firestoreClient.getAllPlaces(TABLE_NAME_PLACE, { task ->
            if (task.isSuccessful) {
                task.result.forEach({
                    allPlaces.add(it.data)
                })
            }
        })
    }
}
