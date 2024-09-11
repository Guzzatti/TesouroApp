// com/example/treasureapp/ui/screens/ClueScreen.kt

package com.example.tesouroapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tesouroapp.ui.theme.TreasureAppTheme

@Composable
fun ClueScreen(navController: NavController, clueNumber: Int) {
    val clues = listOf(
        "O que é grande, redondo, vermelho por dentro e verde por fora? (Resposta: Melancia)",
        "Qual é o animal que anda com as patas para cima? (Resposta: Canguru)",
        "O que tem cabeça e não tem corpo? (Resposta: Alfinete)"
    )

    val currentClue = clues.getOrNull(clueNumber - 1) ?: "Você encontrou o tesouro!"
    val answer = clues.getOrNull(clueNumber - 1)?.substringAfter("(Resposta: ")?.substringBefore(")")
        ?: ""

    var userAnswer by remember { mutableStateOf("") }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = currentClue)
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = userAnswer,
                onValueChange = { userAnswer = it },
                label = { Text("Digite sua resposta") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (userAnswer.equals(answer, ignoreCase = true)) {
                    if (clueNumber < clues.size) {
                        navController.navigate("clue/${clueNumber + 1}")
                    } else {
                        navController.navigate("treasure")
                    }
                }
            }) {
                Text("Próxima Pista")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                if (clueNumber > 1) {
                    navController.navigate("clue/${clueNumber - 1}")
                }
            }) {
                Text("Voltar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClueScreenPreview() {
    TreasureAppTheme {
        ClueScreen(navController = rememberNavController(), clueNumber = 1)
    }
}
