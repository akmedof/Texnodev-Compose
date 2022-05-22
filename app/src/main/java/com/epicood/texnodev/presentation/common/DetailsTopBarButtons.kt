package com.epicood.texnodev.presentation.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.epicood.texnodev.R
import com.epicood.texnodev.ui.theme.topAppBarBackgroundColor
import com.epicood.texnodev.ui.theme.topAppBarContentColor

@Composable
fun DetailsArrowBackButton(
    onArrowBackClick: () -> Unit
){
    Button(
        onClick = { onArrowBackClick() },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
            contentColor = MaterialTheme.colors.topAppBarContentColor),
        elevation = ButtonDefaults.elevation(),
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .width(35.dp)
                .height(35.dp),
//            tint = Color.Black
        )
    }
}

@Composable
fun DetailsFavoriteButton(
//    onArrowBackClick: () -> Unit
){
    Button(
        onClick = { },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
            contentColor = MaterialTheme.colors.topAppBarContentColor),
        elevation = ButtonDefaults.elevation(),
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_favorite),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .width(35.dp)
                .height(35.dp),
//            tint = Color.Black
        )
    }
}