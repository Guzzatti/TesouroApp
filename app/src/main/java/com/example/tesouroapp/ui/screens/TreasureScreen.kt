// com/example/treasureapp/ui/screens/TreasureScreen.kt

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
fun TreasureScreen(navController: NavController) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Parabéns! Você encontrou o tesouro!")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                navController.navigate("home") {
                    popUpTo("home") { inclusive = true }
                }
            }) {
                Text("Voltar para a Tela Inicial")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TreasureScreenPreview() {
    TreasureAppTheme {
        TreasureScreen(navController = rememberNavController())
    }
}
