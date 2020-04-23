package ru.laink.somelist.data.db.enitites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    // Если мы хотим, чтобы имя в таблице отличалось от имени переменной добавляем @ColumnInfo
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amonut")
    var amount: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}