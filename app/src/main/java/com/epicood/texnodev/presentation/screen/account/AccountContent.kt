package com.epicood.texnodev.presentation.screen.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.epicood.texnodev.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.epicood.texnodev.ui.theme.*

@Composable
fun AccountContent(){
    Scaffold() {
        Column() {
            HeadName()
            ProfileCard()
        }
    }
}

@Composable
fun ComposableOptionsUI(){
    Column(
        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        Text(
            text = "General",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colors.textColor
        )
//        GeneralSettingsItem()
    }
}

@ExperimentalMaterialApi
@Composable
fun GeneralSettingsItem(
    icon: Int,
    title: String,
    subTitle: String? = null,
    onClicked: () -> Unit
) {
    Card(
        onClick = { onClicked },
        backgroundColor = MaterialTheme.colors.appBackground,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 0.dp
    ) {
        Row() {

        }
    }
}

@Composable
fun ProfileCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(10.dp),
        backgroundColor = MaterialTheme.colors.appBackground,
        elevation = 0.dp,
        shape = Shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Check Your Profile",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colors.textColor
                )
                Text(
                    text = "texnodevcom@gmail.com",
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Default,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.textColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Button(
                    onClick = { /*TODO*/ },
                    Modifier.padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
                        contentColor = MaterialTheme.colors.topAppBarContentColor
                    ),
                    contentPadding = PaddingValues(),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 2.dp
                    ),
                    shape = Shapes.medium
                ) {
                    Text(
                        text = "View",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Default,
                        fontSize = 16.sp
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.texnodev_icon),
                contentDescription = "",
                modifier = Modifier.height(120.dp)
            )
        }
    }    
}

@Composable
fun HeadName(){
    Text(
        text = "PROFILE SETTINGS",
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.ExtraBold,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.textColor,
        fontSize = 25.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 10.dp)
    )
}

@Composable
@Preview
fun AccountContentPreview(){
    AccountContent()
}