package com.example.programacion_para_moviles

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                        name = "Subida de Archivos",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var filePath by remember { mutableStateOf(TextFieldValue("")) }
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            selectedFileUri = it
            filePath = TextFieldValue(it.path ?: "Ruta no disponible")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Subir Archivo")
        Text(text = "Seleccione un archivo:")
        OutlinedTextField(
            value = filePath,
            onValueChange = { },
            label = { Text("Ruta del archivo") },
            readOnly = true,
            enabled = false,
            trailingIcon = {
                TextButton(onClick = { launcher.launch("*/*") }) {
                    Text(text = "Seleccionar Archivo")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable(enabled = false) {}
                .padding(16.dp)
        )
        Button(
            onClick = { },
        ) {
            Text(text = "Subir Archivo")
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