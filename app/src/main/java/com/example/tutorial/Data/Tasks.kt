package com.example.tutorial.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tasks")
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var task: String,
    var complete: Boolean = false
)
