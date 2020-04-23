package ru.laink.somelist.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.laink.somelist.R
import ru.laink.somelist.data.db.MainDatabase
import ru.laink.somelist.data.repositories.MainRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = MainDatabase(this)
        val repository = MainRepository(database)
        val factory = MainViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }
}
