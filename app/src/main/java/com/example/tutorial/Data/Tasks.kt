package com.example.tutorial.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tasks")
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var task: String,
    @ColumnInfo(defaultValue = "0")
    var complete: Boolean = false
)
