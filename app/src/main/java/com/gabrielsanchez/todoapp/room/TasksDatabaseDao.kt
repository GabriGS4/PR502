package com.gabrielsanchez.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gabrielsanchez.todoapp.models.Tasks
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDatabaseDao {

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Tasks>>

    @Query("SELECT * FROM tasks WHERE id = :id")
    fun getTaskbyId(id: Int): Flow<Tasks>

    @Insert
    suspend fun insertTask(task: Tasks)

    @Update
    suspend fun updateTask(task: Tasks)

    @Delete
    suspend fun deleteTask(task: Tasks)

    @Query("DELETE FROM tasks")
    suspend fun deleteAllTasks()

}