package com.example.myapplication.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String
)