package com.example.programacion_para_moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.programacion_para_moviles.ui.theme.Programacion_Para_MovilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Programacion_Para_MovilesTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Inscripción a un Evento",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var selectedOption by remember { mutableStateOf<String?>(null) }
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Inscripción a un Evento", modifier = Modifier.padding(start = 8.dp))
        Text(text = "Ingresa tu nombre:", modifier = Modifier.padding(start = 4.dp))
        OutlinedTextField(
            value = "",
            onValueChange = { },
        )
        Text(text = "Email:", modifier = Modifier.padding(start = 4.dp))
        OutlinedTextField(
            value = "",
            onValueChange = { },
        )
        Text(text = "¿Asistirá al evento?")
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == "si",
                onClick = { selectedOption = "si" }
            )
            Text(text = "Sí", modifier = Modifier.padding(start = 4.dp))

            RadioButton(
                selected = selectedOption == "no",
                onClick = { selectedOption = "no" }
            )
            Text(text = "No", modifier = Modifier.padding(start = 4.dp))
        }

        Button( onClick = { }) {
            Text(text = "Inscribirse")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Programacion_Para_MovilesTheme {
        Greeting("Android")
    }
}