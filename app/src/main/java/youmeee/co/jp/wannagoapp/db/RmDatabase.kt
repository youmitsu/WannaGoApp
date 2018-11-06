package youmeee.co.jp.wannagoapp.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.IO
import kotlinx.coroutines.experimental.launch
import youmeee.co.jp.wannagoapp.db.dao.ItemDao
import youmeee.co.jp.wannagoapp.db.entity.ItemEntity

/**
 * Room
 */
@Database(entities = [ItemEntity::class], version = 1)
abstract class RmDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        private var INSTANCE: RmDatabase? = null

        fun getDatabase(
                context: Context,
                scope: CoroutineScope): RmDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        RmDatabase::class.java,
                        "database"
                ).addCallback(RmDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class RmDatabaseCallback(
            private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {

                }
            }
        }

        fun populateDatabase(itemDao: ItemDao) {
            itemDao.deleteAll()
        }
    }

}
