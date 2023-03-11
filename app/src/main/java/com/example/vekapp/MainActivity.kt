package com.example.vekapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vekapp.ui.theme.VekAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import kotlin.math.floor
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VekAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Main()
                }
            }
        }
    }
}

var dx: Double = 0.0

var dy: Double = 0.0


@Composable
fun Main() {

    var result by remember {
        mutableStateOf(0.0)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Distância entre 2 pontos",textAlign = TextAlign.Center, fontSize = 30.sp)

        Text(text = "Geometria Analítica",textAlign = TextAlign.Center, fontSize = 25.sp)

        Text(text = "(x1, y1) e (x2, y2)",textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "X1",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var x1 by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = x1,
            label = { Text(text = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                x1 = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Y1",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var y1 by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = y1,
            label = { Text(text = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                y1 = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "X2",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var x2 by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = x2,
            label = { Text(text = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                x2 = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Y2",textAlign = TextAlign.Left,
            modifier = Modifier.width(280.dp))

        var y2 by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = y2,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                y2 = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { result = calcD(x1.text, x2.text, y1.text, y2.text) },
            // Uses ButtonDefaults.ContentPadding by default
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            // Inner content including an icon and a text label
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Calcular")
        }
        
        Spacer(modifier = Modifier.height(20.dp))

        var text = "" + result

        if(verDec(result)){
            text = "Raiz de " + result * result
        }

        Text(text = "Distância: $text", textAlign = TextAlign.Center)

        Text(text = "Delta X: $dx",textAlign = TextAlign.Center)

        Text(text = "Delta Y: $dy",textAlign = TextAlign.Center)
    }
}

fun calcD(x1: String, x2: String, y1: String, y2:String): Double {
    return if(x1.isEmpty() || x2.isEmpty() || y1.isEmpty() || y2.isEmpty()){
                0.0
            }else{
                val a1 = x1.toDouble()
                val a2 = x2.toDouble()
                val b1 = y1.toDouble()
                val b2 = y2.toDouble()
                dx = a1 - a2
                dy = b1 - b2
                sqrt((dx * dx) + (dy * dy))
            }
}

fun verDec(r: Double): Boolean{
    return r > floor(r)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VekAppTheme {
        Main()
    }
}