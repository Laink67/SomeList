package ru.laink.somelist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.laink.somelist.data.db.enitites.Item

@Dao
interface MainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM items")
    fun getAllItems(): LiveData<List<Item>>
}