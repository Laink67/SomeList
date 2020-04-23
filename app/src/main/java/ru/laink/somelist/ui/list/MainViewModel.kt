package ru.laink.somelist.ui.list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.laink.somelist.data.db.enitites.Item
import ru.laink.somelist.data.repositories.MainRepository

class MainViewModel(
    private val repository: MainRepository
) : ViewModel() {

    fun upsert(item: Item) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }

    fun delete(item: Item) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }

    // Не нужен coroutine, т.к. это операция чтения из бд
    fun getAllItems() = repository.getAllItems()
}