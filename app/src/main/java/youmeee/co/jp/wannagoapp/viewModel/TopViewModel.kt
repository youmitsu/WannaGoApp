package youmeee.co.jp.wannagoapp.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main
import youmeee.co.jp.wannagoapp.db.RmDatabase
import youmeee.co.jp.wannagoapp.db.entity.ItemEntity
import youmeee.co.jp.wannagoapp.net.FirestoreClient
import youmeee.co.jp.wannagoapp.repository.ItemRepository
import kotlin.coroutines.experimental.CoroutineContext

/**
 * ViewModel
 */
class TopViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ItemRepository
    private val items: LiveData<List<ItemEntity>>
    //private val places: LiveData<List<Place>>

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    init {
        val dao = RmDatabase.getDatabase(application, scope).itemDao()
        val firestoreClient = FirestoreClient()
        repository = ItemRepository(dao, firestoreClient)
        items = repository.allItems
    }

    fun insert() = scope.launch(Dispatchers.IO) {
        repository.insertPlaces()
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}