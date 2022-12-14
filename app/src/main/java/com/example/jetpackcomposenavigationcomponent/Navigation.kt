package com.example.jetpackcomposenavigationcomponent

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson

@Composable
fun NavigatePage() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainPage") {
        composable("mainPage") {
            MainPage(navController = navController)
        }
        composable(
            "secondPage/{person}",
            arguments = listOf(navArgument("person") { type = NavType.StringType })
        ) {
            val json = it.arguments?.getString("person")
            val person = Gson().fromJson(json, Person::class.java)
            SecondPage(navController = navController, person  )

        }
        composable("thirdPage") {
            ThirdPage()
        }
    }
}