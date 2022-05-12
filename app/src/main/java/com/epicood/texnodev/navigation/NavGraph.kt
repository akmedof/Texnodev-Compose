package com.epicood.texnodev.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.epicood.texnodev.presentation.screen.home.HomeScreen
import com.epicood.texnodev.presentation.screen.splash.SplashScreen
import com.epicood.texnodev.presentation.screen.welcome.WelcomeScreen
import com.epicood.texnodev.util.Constants.DETAILS_ARGUMENT_KEY
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Splash.rout ){
        composable(route = Screen.Splash.rout){
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.rout){
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.rout){
            HomeScreen(navController = navController)
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