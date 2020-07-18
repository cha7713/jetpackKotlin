package com.example.androidroomkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.androidroomkotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        binding.lifecycleOwner = this// livedata를 활용하기 위해서
//        var db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "database-name"
//        ).build()

//        db.todoDao()?.getAll()?.observe(this, Observer {
//            todos -> result.text = todos.toString()
//        })
        val model: MainViewModel by viewModels()
//        model.getAll()?.observe(this, Observer { todo ->
//            result.text = todo.toString()
//        })

        binding.viewModel = model //viewModel 바인딩

//        addBtn.setOnClickListener(View.OnClickListener {
//            lifecycleScope.launch(Dispatchers.IO) {
////                db.todoDao()?.insert(Todo(input.text.toString()))
//                //model.insert(Todo(input.text.toString()))
//            }
//
//            //result.text= db.todoDao()?.getAll().toString()
//        })

        //Room 한번치고 art enter 하면 room dependency 추가가능
    }
}
