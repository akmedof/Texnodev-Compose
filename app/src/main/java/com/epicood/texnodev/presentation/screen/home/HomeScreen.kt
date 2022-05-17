package com.epicood.texnodev.presentation.screen.home

<<<<<<< HEAD
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.epicood.texnodev.presentation.common.ListContent

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
){

    val allPosts = homeViewModel.getAllPosts.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        },
        content = {
            ListContent(
                posts = allPosts,
                navController = navController
            )
        }
    )
=======
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(){

>>>>>>> origin/master
}