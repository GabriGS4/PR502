package com.gabrielsanchez.todoapp.states

import com.gabrielsanchez.todoapp.models.Tasks

data class TasksState(
    val tasksList: List<Tasks> = emptyList()
)