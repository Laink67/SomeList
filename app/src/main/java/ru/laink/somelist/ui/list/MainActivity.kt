package ru.laink.somelist.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.laink.somelist.R
import ru.laink.somelist.data.db.MainDatabase
import ru.laink.somelist.data.db.enitites.Item
import ru.laink.somelist.data.repositories.MainRepository
import ru.laink.somelist.other.ItemAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = MainDatabase(this)
        val repository = MainRepository(database)
        val factory = MainViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        val adapter = ItemAdapter(listOf(), viewModel)

        rvItems.layoutManager = LinearLayoutManager(this)
        rvItems.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddItemDialog(this, object : AddDialogListener{
                override fun onAddButtonClicked(item: Item) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}
