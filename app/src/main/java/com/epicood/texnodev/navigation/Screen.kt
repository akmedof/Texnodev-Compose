package com.epicood.texnodev.navigation

sealed class Screen(val rout: String) {

    object Splash: Screen("splash_screen")
    object Welcome: Screen("welcome_screen")
    object Home: Screen("home_screen")
    object Details: Screen("details_screen/{postId}"){
        fun passPostId(postId: Int): String{
            return "details_screen/$postId"
        }
    }
    object Search: Screen("search_screen")

}