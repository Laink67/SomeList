package ru.laink.somelist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.laink.somelist.data.db.enitites.Item

@Database(
    entities = [Item::class],
    version = 1
)
abstract class MainDatabase : RoomDatabase() {

    abstract fun getMainDao(): MainDao

    // Для реализации Singletone
    companion object {
        // Права на этот экземпляр доступны другим потокам
        @Volatile
        private var instance: MainDatabase? = null
        private val LOCK = Any()

        // Функция выполняется при каждом создании MainDatabase
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: createDatabase(
                    context
                ).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MainDatabase::class.java,
                "MainDB.db"
            ).build()
    }
}