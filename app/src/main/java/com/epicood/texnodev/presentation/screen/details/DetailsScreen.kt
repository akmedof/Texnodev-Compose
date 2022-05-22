package com.epicood.texnodev.presentation.screen.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.epicood.texnodev.navigation.Screen
import com.epicood.texnodev.presentation.screen.home.HomeTopBar

@ExperimentalCoilApi
@Composable
fun DetailsScreen(
    navController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel(),
){
    val selectedPost by detailsViewModel.selectedPost.collectAsState()

    Scaffold() {
        DetailsContent(
            selectPost = selectedPost,
            onArrowBackClick = {
                navController.popBackStack()
            }
        )
    }
}