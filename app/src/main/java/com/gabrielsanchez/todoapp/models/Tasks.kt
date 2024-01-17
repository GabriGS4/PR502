package com.gabrielsanchez.todoapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("content")
    val content: String,
    @ColumnInfo("status")
    val status: Boolean = false
)