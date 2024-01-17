package com.gabrielsanchez.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gabrielsanchez.todoapp.viewmodels.TasksViewModel
import com.gabrielsanchez.todoapp.views.EditTaskView
import com.gabrielsanchez.todoapp.views.NewTaskView
import com.gabrielsanchez.todoapp.views.TasksView
import com.gabrielsanchez.todoapp.views.DeleteTasksView

@Composable
fun NavManager(viewModel: TasksViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.Tasks.route) {
        composable(AppScreens.Tasks.route) {
            TasksView(navController, viewModel)
        }

        composable(AppScreens.NewTask.route) {
            NewTaskView(navController, viewModel)
        }

        composable(AppScreens.EditTask.route + "/{id}/{title}/{content}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("title") { type = NavType.StringType },
            navArgument("content") { type = NavType.StringType }
        )) {
            EditTaskView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("title"),
                it.arguments?.getString("content")
            )
        }

        composable(AppScreens.DeleteAllTasks.route) {
            DeleteTasksView(navController, viewModel)
        }
    }

}