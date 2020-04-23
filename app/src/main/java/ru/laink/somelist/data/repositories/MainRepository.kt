package ru.laink.somelist.data.repositories

import ru.laink.somelist.data.db.MainDatabase
import ru.laink.somelist.data.db.enitites.Item

class MainRepository(
    private val db: MainDatabase
) {
    suspend fun upsert(item: Item) = db.getMainDao().upsert(item)

    suspend fun delete(item: Item) = db.getMainDao().delete(item)

    fun getAllItems() = db.getMainDao().getAllItems()
}