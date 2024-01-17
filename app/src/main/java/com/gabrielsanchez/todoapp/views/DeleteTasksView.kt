package com.gabrielsanchez.todoapp.views

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gabrielsanchez.todoapp.models.Tasks
import com.gabrielsanchez.todoapp.navigation.AppScreens
import com.gabrielsanchez.todoapp.viewmodels.TasksViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteTasksView(navController: NavController, viewModel: TasksViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Delete All Tasks",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        ContentDeleteView(it, navController, viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentDeleteView(
    it: PaddingValues,
    navController: NavController,
    viewModel: TasksViewModel,
) {

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(it)
            .padding(top = 30.dp)
    ) {
        Text(
            text = "Are you sure you want to delete all tasks?",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ElevatedButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = "No")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    viewModel.deleteAllTasks()
                    Toast.makeText(
                        navController.context,
                        "All tasks deleted",
                        Toast.LENGTH_SHORT
                    ).show()
                    navController.popBackStack()
                },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = "Yes")
            }
        }
    }
}