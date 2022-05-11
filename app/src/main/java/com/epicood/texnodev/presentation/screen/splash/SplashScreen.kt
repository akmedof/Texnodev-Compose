package com.epicood.texnodev.presentation.screen.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.epicood.texnodev.R
import com.epicood.texnodev.ui.theme.Purple500
import com.epicood.texnodev.ui.theme.Purple700

@Composable
fun SplashScreen(navController: NavHostController){
    Splash()
}

@Composable
fun Splash(){
    Box(
        modifier = Modifier
            .background(Brush.verticalGradient(listOf(Purple700, Purple500)))
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Image(
            painter = painterResource(id = R.drawable.spinnerlogo),
            contentDescription = stringResource(R.string.app_logo),
            colorFilter = ColorFilter.tint(Color.White)
        )
    }

}

@Composable
@Preview
fun SplashScreenPreview(){
    Splash()
}
