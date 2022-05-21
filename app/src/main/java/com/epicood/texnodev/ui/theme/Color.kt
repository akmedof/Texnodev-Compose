package com.epicood.texnodev.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White

val Purple200 = Color(0xFF3B6BFF)
val Purple500 = Color(0xFFE91E63)
val Purple700 = Color(0xFF1C3BE6)
val Teal200 = Color(0xFF03DAC5)


val LightGrey = Color(0xFFF5F1F1)
val DarkGrey = Color(0xFF17171A)
val BlueGrey = Color(0xFF3B6BFF)

val ShimmerLightGray = Color(0xFFF1F1F1)
val ShimmerMediumGray = Color(0xFFE3E3E3)
val ShimmerDarkGray = Color(0xFF1D1D1D)

val Colors.welcomeScreenBackgroundColor
    @Composable
    get() = if(isLight) Color.White else Color.Black

val Colors.titleColor
    @Composable
    get() = if(isLight) White else LightGray

val Colors.descriptionColor
    @Composable
    get() = if(isLight) DarkGrey.copy(0.5f) else LightGray.copy(0.5f)

val Colors.activateIndicatorColor
    @Composable
    get() = if(isLight) Purple500 else Purple700

val Colors.inActivateIndicatorColor
    @Composable
    get() = if(isLight) LightGrey else DarkGrey

val Colors.bottomBackgroundColor
    @Composable
    get() = if(isLight) Purple500 else Purple700

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if(isLight) White else BlueGrey

val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if(isLight) Purple500 else DarkGrey