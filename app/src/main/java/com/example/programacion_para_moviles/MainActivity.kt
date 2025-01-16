package com.example.programacion_para_moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.programacion_para_moviles.ui.theme.Programacion_Para_MovilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Programacion_Para_MovilesTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Formulario de Contacto",
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
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Formulario de Contacto")
        Text(text= "Nombre", modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {  },
        )
        Text(text= "Teléfono", modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = " ",
            onValueChange = { },
            label = {  },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        )
        Text(text= "Mensaje", modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = {  },
            modifier = Modifier.padding(8.dp)
                .size(width = 300.dp, height = 100.dp),
            maxLines = 4
        )
        Button(
            onClick = { },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Enviar")
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