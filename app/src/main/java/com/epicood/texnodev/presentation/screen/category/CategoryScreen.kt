package com.epicood.texnodev.presentation.screen.category

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.epicood.texnodev.R
import com.epicood.texnodev.presentation.bottom.BottomBarMenuScreen
import com.epicood.texnodev.ui.theme.DarkGrey
import com.epicood.texnodev.ui.theme.LightGrey
import com.epicood.texnodev.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import com.epicood.texnodev.ui.theme.SMALE_PADDING

@Composable
fun CategoryScreen(
    navController: NavHostController
){
    Scaffold(
        bottomBar = { BottomBarMenuScreen(navController = navController)},
        content = {
            CategoryUI()
        }
    )
}

@Composable
fun CategoryUI(){
    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(500.dp),
            painter = painterResource(id = R.drawable.ic_category_icon),
            contentDescription = stringResource(R.string.network_error_icon),
            tint = if (isSystemInDarkTheme()) LightGrey else DarkGrey
        )
        Text(
            modifier = Modifier
                .padding(SMALE_PADDING),
            text = "Category Screen",
            color = if (isSystemInDarkTheme()) LightGrey else DarkGrey,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.h4.fontSize
        )
    }
}