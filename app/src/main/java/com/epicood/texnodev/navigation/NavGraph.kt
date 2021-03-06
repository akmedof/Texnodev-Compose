package com.epicood.texnodev.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.epicood.texnodev.presentation.screen.account.AccountScreen
import com.epicood.texnodev.presentation.screen.category.CategoryScreen
import com.epicood.texnodev.presentation.screen.details.DetailsScreen
import com.epicood.texnodev.presentation.screen.favorite.FavoriteScreen
import com.epicood.texnodev.presentation.screen.home.HomeScreen
import com.epicood.texnodev.presentation.screen.search.SearchScreen
import com.epicood.texnodev.presentation.screen.splash.SplashScreen
import com.epicood.texnodev.presentation.screen.welcome.WelcomeScreen
import com.epicood.texnodev.util.Constants.DETAILS_ARGUMENT_KEY
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.rout ){
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
            DetailsScreen(navController = navController)
        }
        composable(route = Screen.Search.rout){
            SearchScreen(navController = navController)
        }
        composable(route = Screen.Category.rout){
            CategoryScreen(navController = navController)
        }
        composable(route = Screen.Favorite.rout){
            FavoriteScreen(navController = navController)
        }
        composable(route = Screen.Account.rout){
            AccountScreen(navController = navController)
        }
    }
}