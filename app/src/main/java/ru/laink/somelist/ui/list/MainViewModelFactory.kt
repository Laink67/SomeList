package ru.laink.somelist.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.laink.somelist.data.repositories.MainRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val repository: MainRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}