package com.example.myapplication.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Guruh(
    @PrimaryKey(autoGenerate = true)
    var guruh:  Int = 0,
    var sinf: String
)
