package com.gabrielsanchez.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.gabrielsanchez.todoapp.navigation.NavManager
import com.gabrielsanchez.todoapp.room.TasksDatabase
import com.gabrielsanchez.todoapp.ui.theme.ToDoAppTheme
import com.gabrielsanchez.todoapp.viewmodels.TasksViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this, TasksDatabase::class.java, "db_tasks").build()
                    val dao = database.tasksDao()

                    val viewModel = TasksViewModel(dao)
                    NavManager(viewModel = viewModel)
                }
            }
        }
    }
}
