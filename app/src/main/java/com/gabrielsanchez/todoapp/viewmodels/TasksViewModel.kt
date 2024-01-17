package com.gabrielsanchez.todoapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielsanchez.todoapp.models.Tasks
import com.gabrielsanchez.todoapp.room.TasksDatabaseDao
import com.gabrielsanchez.todoapp.states.TasksState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TasksViewModel(
    private val dao: TasksDatabaseDao
): ViewModel() {
    var state by mutableStateOf(TasksState())
        private set

    init {
        viewModelScope.launch {
            dao.getAllTasks().collectLatest {
                state = state.copy(
                    tasksList = it
                )
            }
        }
    }

    fun insertTask(task: Tasks) = viewModelScope.launch {
        dao.insertTask(task = task)
    }

    fun updateTask(task: Tasks) = viewModelScope.launch {
        dao.updateTask(task = task)
    }

    fun deleteTask(task: Tasks) = viewModelScope.launch {
        dao.deleteTask(task = task)
    }

    fun deleteAllTasks() = viewModelScope.launch {
        dao.deleteAllTasks()
    }


}