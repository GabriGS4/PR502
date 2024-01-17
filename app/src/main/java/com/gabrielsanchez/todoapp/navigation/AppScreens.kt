package com.gabrielsanchez.todoapp.navigation

sealed class AppScreens(val route: String) {
    object Tasks : AppScreens("home")
    object NewTask : AppScreens("new")
    object EditTask : AppScreens("edit")
    object DeleteAllTasks : AppScreens("deleteAll")
}
