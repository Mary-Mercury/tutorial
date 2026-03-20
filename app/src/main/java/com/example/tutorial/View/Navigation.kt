package com.example.tutorial.View

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "tasks"
    ) {
        composable(route = "tasks") {
            TasksScreen(viewModel=viewModel, navController=navController)
        }
        composable(
            route="newTask",
            enterTransition = { slideInHorizontally(tween(500)) { it } },
            popExitTransition = { slideOutHorizontally(tween(500)) { -it } },
        ) {
            AddNewTask(viewModel=viewModel, navController=navController)
        }
        composable(
            route="edit/{taskId}/{task}",
            enterTransition = { slideInHorizontally(tween(500)) { it } },
            popExitTransition = { slideOutHorizontally(tween(500)) { -it } },
            arguments = listOf(
                navArgument("taskId") { type = NavType.IntType },
                navArgument(name = "task") { type = NavType.StringType }),
        ) {
            val taskId = it.arguments?.getInt("taskId")!!
            val task = it.arguments?.getString("task")!!

            EditTask(viewModel=viewModel, navController=navController,
                taskId = taskId, task = task)
        }
    }
}
