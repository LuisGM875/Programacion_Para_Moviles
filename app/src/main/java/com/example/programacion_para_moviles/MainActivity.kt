package com.example.programacion_para_moviles

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.programacion_para_moviles.ui.theme.Programacion_Para_MovilesTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Programacion_Para_MovilesTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Reserva de Hotel",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var entryDate by remember { mutableStateOf("") }
    var exitDate by remember { mutableStateOf("") }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    fun selectDate(onDateSelected: (String) -> Unit) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDay ->
                val date = "${selectedDay}/${selectedMonth + 1}/${selectedYear}"
                onDateSelected(date)
            },
            year,
            month,
            day
        ).show()
    }

    Column (modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Reserva de Habitación", modifier = modifier.padding(1.dp))
        Text(text = "Fecha de Entrada:", modifier = modifier.padding(4.dp))
        OutlinedTextField(
            value = entryDate,
            onValueChange = { entryDate = it },
            label = { Text("Fecha de Entrada") },
            trailingIcon = {
                IconButton(onClick = { selectDate { entryDate = it } }) {
                    Icon(Icons.Filled.DateRange, contentDescription = "Seleccionar Fecha")
                }
            },
        )
        Text(text = "Fecha de Salida:", modifier = modifier.padding(4.dp))
        OutlinedTextField(
            value = exitDate,
            onValueChange = { exitDate = it  },
            label = { Text("Fecha de Salida") },
            trailingIcon = {
                IconButton(onClick = { selectDate { exitDate = it } }) {
                    Icon(Icons.Filled.DateRange, contentDescription = "Seleccionar Fecha")
                }
            },
        )
        Text(text = "Número de Personas:", modifier = modifier.padding(4.dp))
        var numberOfPeople by remember { mutableStateOf("") }
        OutlinedTextField(
            value = numberOfPeople,
            onValueChange = {
                if (it.all { char -> char.isDigit() }) { // Asegura que solo se escriban números
                    val input = it.toIntOrNull()
                    if (input == null || input in 1..10) {
                        numberOfPeople = it
                    }
                }
            },
            label = { Text("Número de Personas") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = { /* TODO */ },
            modifier = modifier.padding(4.dp)
        ) {
            Text(text = "Reservar")
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