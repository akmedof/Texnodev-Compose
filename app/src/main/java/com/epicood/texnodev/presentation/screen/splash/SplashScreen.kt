package com.epicood.texnodev.presentation.screen.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.window.SplashScreen
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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

    val degress = remember{ Animatable(0f)}
    
    LaunchedEffect(key1 = true){
        degress.animateTo(
            targetValue = 1800f,
            animationSpec = tween(
                durationMillis = 5000,
                delayMillis = 200
            )
        )
    }

    Splash(degrees = degress.value)
}

@Composable
fun Splash(degrees : Float){
    if(isSystemInDarkTheme()){
        Box(
            modifier = Modifier
                .background(Brush.verticalGradient(listOf(Purple700, Purple500)))
                .fillMaxSize(),
            contentAlignment = Alignment.Center

        ){
            Image(
                modifier = Modifier.rotate(degrees = degrees),
                painter = painterResource(id = R.drawable.spinnerlogo),
                contentDescription = stringResource(R.string.app_logo),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }else{
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            contentAlignment = Alignment.Center

        ){
            Image(
                modifier = Modifier.rotate(degrees = degrees),
                painter = painterResource(id = R.drawable.spinnerlogo),
                contentDescription = stringResource(R.string.app_logo),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }


}

@Composable
@Preview
fun SplashScreenPreview(){
    Splash(degrees = 0f)
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashScreenDarkPreview(){
    Splash(degrees = 0f)
}
