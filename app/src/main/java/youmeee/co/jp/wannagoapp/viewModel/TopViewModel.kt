package youmeee.co.jp.wannagoapp.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main
import youmeee.co.jp.wannagoapp.db.RmDatabase
import youmeee.co.jp.wannagoapp.db.entity.ItemEntity
import youmeee.co.jp.wannagoapp.repository.ItemRepository
import kotlin.coroutines.experimental.CoroutineContext

/**
 * ViewModel
 */
class TopViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ItemRepository
    private val items: LiveData<List<ItemEntity>>

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    init {
        val dao = RmDatabase.getDatabase(application, scope).itemDao()
        repository = ItemRepository(dao)
        items = repository.allItems
    }

    fun insert(item: ItemEntity) = scope.launch(Dispatchers.IO) {
        repository.insert(item)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}