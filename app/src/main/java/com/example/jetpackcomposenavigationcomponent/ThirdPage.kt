package com.example.jetpackcomposenavigationcomponent

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp

@Composable
fun ThirdPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Third Page", fontSize = 50.sp)
    }

    val context = LocalContext.current
    val activity = (LocalContext.current as Activity)
    // we can give the back button the task we want
    BackHandler(onBack = {
        Toast.makeText(context, "BackHandler", Toast.LENGTH_SHORT).show()
        activity.finish()
    })
}