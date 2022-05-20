package com.epicood.texnodev.presentation.bottom

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.epicood.texnodev.navigation.Screen
import com.epicood.texnodev.ui.theme.topAppBarBackgroundColor
import com.epicood.texnodev.ui.theme.topAppBarContentColor

@Composable
fun BottomBarMenuScreen(navController: NavHostController){
    val screens = listOf(
        Screen.Home,
        Screen.Category,
        Screen.Favorite,
        Screen.Account
    )
    val navBackStackEntity by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntity?.destination

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        contentColor = MaterialTheme.colors.topAppBarContentColor
    ) {
        screens.forEach{ screen ->
            if (currentDestination != null) {
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination,
    navController: NavHostController
){
    BottomNavigationItem(
//        unselectedContentColor = MaterialTheme.colors.topAppBarBackgroundColor,
//        selectedContentColor = MaterialTheme.colors.topAppBarContentColor,

        label = {
            Text(text = screen.title.toString())
        },
        icon = {
            Icon(imageVector = screen.icon!!, contentDescription = "Navigation Icon")
        },
        selected = currentDestination.hierarchy.any{
            it.route == screen.rout
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.rout)
        }
    )

}