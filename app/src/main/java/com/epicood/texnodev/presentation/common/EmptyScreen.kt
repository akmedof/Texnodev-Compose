package com.epicood.texnodev.presentation.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.paging.LoadState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.epicood.texnodev.R
import com.epicood.texnodev.ui.theme.DarkGrey
import com.epicood.texnodev.ui.theme.LightGrey
import com.epicood.texnodev.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import com.epicood.texnodev.ui.theme.SMALE_PADDING
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(error: LoadState.Error){
    val message by remember{
        mutableStateOf(parseErrorMessage(error = error))
    }
    val icon by remember {
        mutableStateOf(R.drawable.network_error)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.size(NETWORK_ERROR_ICON_HEIGHT),
            painter = painterResource(id = icon),
            contentDescription = stringResource(R.string.network_error_icon),
            tint = if (isSystemInDarkTheme()) LightGrey else DarkGrey
        )
        Text(
            modifier = Modifier.padding(SMALE_PADDING),
            text = message,
            color = if (isSystemInDarkTheme()) LightGrey else DarkGrey,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )
    }
}

fun parseErrorMessage(error: LoadState.Error): String{
    return when (error.error){
        is SocketTimeoutException ->{
            "Server Unavailable."
        }
        is ConnectException ->{
            "Internet Unavailable."
        }
        else -> "Unknown Error."
    }
}

@Composable
@Preview(showBackground = true)
fun EmptyScreenPreview(){
    EmptyScreen(error = LoadState.Error(SocketTimeoutException()))
}
