package com.example.androidroomkotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (
    var title: String //생성자
){@PrimaryKey(autoGenerate = true) var id: Int = 0}