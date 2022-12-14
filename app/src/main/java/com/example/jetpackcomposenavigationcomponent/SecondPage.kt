package com.example.jetpackcomposenavigationcomponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SecondPage(navController: NavController, person: Person) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Second Page", fontSize = 50.sp)
        Text(text = "Username: ${person.username}")
        Text(text = "Age: ${person.userAge}")
        Text(text = "Height: ${person.userHeight}")
        Text(text = "Married Status: ${person.userMarriedStatus}")

        Button(onClick = {
            navController.navigate("thirdPage") {
                popUpTo("secondPage") { inclusive = true }
            }
        }) {
            Text(text = "Third Page Go")
        }
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Main Page Back")
        }
    }
}
