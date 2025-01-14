package com.example.programacion_para_moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                        name = "Encuesta de Satisfacción",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Encuesta de Satisfacción", modifier = modifier.padding(bottom = 16.dp)
        )
        Text(text = "Nombre:")
        OutlinedTextField(
            value = "",
            onValueChange = {},
        )
        Text(text = "Nivel de satisfacción:")
        RangeSlider(
            value = 1f..1f,
            onValueChange = {},
            valueRange = 1f..10f,
        )
        Text(text = "Comentarios:")
        OutlinedTextField(
            value = "",
            onValueChange = {},
            maxLines = 4,
        )
        Button(
            onClick = { /* TODO */ },
        ) {
            Text(text = "Enviar")
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