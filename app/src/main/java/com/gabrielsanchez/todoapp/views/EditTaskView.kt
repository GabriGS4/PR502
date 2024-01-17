package com.gabrielsanchez.todoapp.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gabrielsanchez.todoapp.models.Tasks
import com.gabrielsanchez.todoapp.viewmodels.TasksViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTaskView(navController: NavController, viewModel: TasksViewModel, id: Int, title: String?, content: String?) {
    var title = remember { mutableStateOf(title) }
    var content = remember { mutableStateOf(content) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Editar View", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (title.value!!.isEmpty() || content.value!!.isEmpty()) {
                        Toast.makeText(navController.context, "Title and Content a re required", Toast.LENGTH_SHORT).show()
                        return@FloatingActionButton
                    }
                    val task = Tasks(id = id, title = title.value!!, content = content.value!!, status = false)

                    viewModel.updateTask(task)
                    navController.popBackStack()
                },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
                shape = CircleShape,
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Agregar")
            }
        }
    ) {
        ContentEditarView(it, navController, viewModel, id, title, content)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentEditarView(it: PaddingValues, navController: NavController, viewModel: TasksViewModel, id: Int, title: MutableState<String?>, content: MutableState<String?>) {


    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = title.value ?: "",
            onValueChange = { title.value = it },
            label = { Text(text = "Title") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = content.value ?: "",
            onValueChange = { content.value = it },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

    }
}