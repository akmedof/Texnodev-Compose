package com.epicood.texnodev.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.epicood.texnodev.presentation.screen.splash.SplashScreen
import com.epicood.texnodev.presentation.screen.welcome.WelcomeScreen
import com.epicood.texnodev.util.Constants.DETAILS_ARGUMENT_KEY
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Welcome.rout ){
        composable(route = Screen.Splash.rout){
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.rout){
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.rout){

        }
        composable(
            route = Screen.Details.rout,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY){
                type = NavType.IntType
            })
        ){

        }
        composable(route = Screen.Search.rout){

        }
    }
}