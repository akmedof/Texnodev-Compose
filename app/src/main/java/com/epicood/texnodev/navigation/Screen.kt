package com.epicood.texnodev.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.epicood.texnodev.R

sealed class Screen(
    val rout: String,
    val title: String? = null,
    val icon: Int? = null
    ) {

    object Splash: Screen("splash_screen")

    object Welcome: Screen("welcome_screen")

    object Home: Screen(
        rout = "home_screen",
        title = "Home",
        icon = R.drawable.ic_news_icon
    )
    object Details: Screen("details_screen/{postId}"){
        fun passPostId(postId: Int): String{
            return "details_screen/$postId"
        }
    }

    object Search: Screen("search_screen")

    object Category: Screen(
        rout = "category_screen",
        title = "Category",
        icon = R.drawable.ic_category_icon
    )
    object Favorite: Screen(
        rout = "favorite_screen",
        title = "Favorite",
        icon = R.drawable.ic_favorite_icon
    )
    object Account: Screen(
        rout = "account_screen",
        title = "Account",
        icon = R.drawable.ic_profile_icon
    )

}