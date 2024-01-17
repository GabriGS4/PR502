package com.gabrielsanchez.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gabrielsanchez.todoapp.models.Tasks

@Database(
    entities = [Tasks::class],
    version = 1,
    exportSchema = false
)
abstract class TasksDatabase: RoomDatabase() {
    abstract fun tasksDao(): TasksDatabaseDao
}