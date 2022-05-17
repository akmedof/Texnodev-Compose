package com.epicood.texnodev.presentation.screen.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.epicood.texnodev.R
import com.epicood.texnodev.ui.theme.topAppBarBackgroundColor
import com.epicood.texnodev.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar(onSearchClicked: () -> Unit){
    TopAppBar(
        title = {
            Text(
                text = "Texnodev",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon))
            }
        }
    )
}

@Composable
@Preview
fun HomeTopBarPreview(){
    HomeTopBar{}
}
