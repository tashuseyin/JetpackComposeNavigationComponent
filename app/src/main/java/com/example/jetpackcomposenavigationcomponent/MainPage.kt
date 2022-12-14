package com.example.jetpackcomposenavigationcomponent

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson


@Composable
fun MainPage(navController: NavController) {
    val context = LocalContext.current
    val counter = remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Main Page", fontSize = 50.sp)
        Button(onClick = {
            val person = Person("Kaori", 23, 170F, false)
            val personJson = Gson().toJson(person)
            navController.navigate("secondPage/$personJson")
        }){
            Text(text = "Second Page Go")
        }
        
        Text(text = "Counter: ${counter.value}")
        Button(onClick = { counter.value += 1 }) {
            Text(text = "Tıkla")
        }
    }
    LaunchedEffect(key1 = true ){
        Toast.makeText(context, "MainPage LaunchedEffect çalıştı.", Toast.LENGTH_SHORT).show()
    }
    SideEffect {
        Toast.makeText(context, "MainPage SideEffect çalıştı.", Toast.LENGTH_SHORT).show()
    }
    DisposableEffect(Unit) {
        onDispose {
            Toast.makeText(context, "MainPage DisposableEffect çalıştı.", Toast.LENGTH_SHORT).show()
        }
    }
}