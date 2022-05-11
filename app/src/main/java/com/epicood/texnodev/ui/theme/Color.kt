package com.epicood.texnodev.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFFE91E63)
val Purple700 = Color(0xFF1C3BE6)
val Teal200 = Color(0xFF03DAC5)


val LightGrey = Color(0xFFF5F1F1)
val DarkGrey = Color(0xFF151616)

val Colors.welcomeScreenBackgroundColor
    @Composable
    get() = if(isLight) Color.White else Color.Black

val Colors.titleColor
    @Composable
    get() = if(isLight) DarkGray else LightGray

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