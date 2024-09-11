// com/example/treasureapp/ui/navigation/Navigation.kt

package com.example.tesouroapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tesouroapp.ui.screens.ClueScreen
import com.example.tesouroapp.ui.screens.HomeScreen
import com.example.tesouroapp.ui.screens.TreasureScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("clue/{clueNumber}") { backStackEntry ->
            val clueNumber = backStackEntry.arguments?.getString("clueNumber")?.toInt() ?: 1
            ClueScreen(navController = navController, clueNumber = clueNumber)
        }
        composable("treasure") {
            TreasureScreen(navController = navController)
        }
    }
}
