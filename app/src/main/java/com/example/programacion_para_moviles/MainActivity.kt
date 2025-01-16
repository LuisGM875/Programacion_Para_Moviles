package com.example.programacion_para_moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
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
                        name = "Pagar con Tarjeta",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expiredDate by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pagar con Tarjeta", modifier = Modifier.padding(8.dp))
        Text(text= "Número de Tarjeta:", modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text= "Fecha de Expiración: ", modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = expiredDate,
            onValueChange = { newValue ->
                expiredDate = formatExpirationDateInput(newValue)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text="CVV: ", modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {},
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Pagar")
        }
    }
}


fun formatExpirationDateInput(input: TextFieldValue): TextFieldValue {
    val digits = input.text.filter { it.isDigit() }
    val maxLength = 4

    val validDigits = if (digits.length > maxLength) digits.substring(0, maxLength) else digits

    val formattedText = buildString {
        if (validDigits.length > 2) {
            append(validDigits.substring(0, 2) + "/")
            append(validDigits.substring(2, validDigits.length))
        } else {
            append(validDigits)
        }
    }

    val cursorPosition = when {
        validDigits.length == 2 -> 3
        validDigits.length > 2 -> formattedText.length
        else -> validDigits.length
    }
    return TextFieldValue(text = formattedText, selection = TextRange(cursorPosition))
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Programacion_Para_MovilesTheme {
        Greeting("Android")
    }
}