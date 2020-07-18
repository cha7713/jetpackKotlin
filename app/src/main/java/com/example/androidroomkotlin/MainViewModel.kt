package com.example.androidroomkotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var todos: LiveData<List<Todo?>>?

    var newTodo : String? = null

    private var db = Room.databaseBuilder(
        application, AppDatabase::class.java, "database-name"
    ).build()

    fun getAll(): LiveData<List<Todo?>>? {
        return db.todoDao()?.getAll()
    }

    fun insert(todo: String) { // suspend 키워드를 사용하면 반드시 coroutine scope 내에서 사용되어야 한다.
        viewModelScope.launch(Dispatchers.IO) { db.todoDao()?.insert(Todo(todo)) }
    }

    init {
        todos = getAll()
    }
}