package com.epicood.texnodev.presentation.screen.search

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.epicood.texnodev.presentation.bottom.BottomBarMenuScreen
import com.epicood.texnodev.presentation.common.ListContent

@ExperimentalCoilApi
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
){
    val searchQuery by searchViewModel.searchQuery
    val posts = searchViewModel.searchPosts.collectAsLazyPagingItems()
    Log.d("Search", posts


        .toString())

    Scaffold(
        topBar = {
            SearchTopBar(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                },
                onSearchClicked = {
                    Log.d("Search", it.toString())
                    searchViewModel.searchPosts(query = it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                }
            )
        },
//        bottomBar = { BottomBarMenuScreen(navController = navController)},
        content = {
            ListContent(posts = posts, navController = navController)
        }
    )
}