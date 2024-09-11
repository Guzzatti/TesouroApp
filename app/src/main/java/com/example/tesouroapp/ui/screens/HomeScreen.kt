// com/example/treasureapp/ui/screens/HomeScreen.kt

package com.example.tesouroapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tesouroapp.ui.theme.TreasureAppTheme

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                navController.navigate("clue/1")
            }) {
                Text("Iniciar Caça ao Tesouro")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TreasureAppTheme {
        HomeScreen(navController = rememberNavController())
    }
}
