package com.epicood.texnodev.presentation.screen.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.epicood.texnodev.navigation.Screen
import com.epicood.texnodev.presentation.bottom.BottomBarMenuScreen
import com.epicood.texnodev.presentation.common.ListContent

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val allPosts = homeViewModel.getAllPosts.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {
                navController.navigate(Screen.Search.rout)
            })
        },
        bottomBar = {
            BottomBarMenuScreen(navController = navController)
        },
        content = {
            ListContent(
                posts = allPosts,
                navController = navController
            )
        }
    )
}