package com.epicood.texnodev.presentation.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.epicood.texnodev.navigation.Screen
import com.epicood.texnodev.ui.theme.Shapes
import com.epicood.texnodev.ui.theme.cardUIBackground
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
//    Spacer(modifier = Modifier.width(30.dp))
    BottomNavigationItem(
//        unselectedContentColor = MaterialTheme.colors.topAppBarBackgroundColor,
//        selectedContentColor = MaterialTheme.colors.topAppBarContentColor,
        label = {
            Modifier.padding(top = 10.dp)
            Text(text = screen.title.toString(), fontWeight = FontWeight.Bold)
        },
        icon = {
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .clip(shape = Shapes.medium)
//                    .background(MaterialTheme.colors.cardUIBackground)
            ) {
                Icon(painter = painterResource(id = screen.icon!!), contentDescription = "Navigation Icon")
            }
        },
        selected = currentDestination.hierarchy.any{
            it.route == screen.rout
        },
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.rout)
        }
    )

}