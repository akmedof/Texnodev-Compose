package com.epicood.texnodev.presentation.screen.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.epicood.texnodev.R
import com.epicood.texnodev.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun SettingsScreen(){
    Column {
        HeadText()
        ProfileCardUI()
        GeneralOptionsUI()
        SupportOptionsUI()

    }
}

@ExperimentalMaterialApi
@Composable
fun SupportOptionsUI() {
    Column(
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .padding(top = 10.dp)
    ) {
        Text(
            text = "Support",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colors.baseTitleTextColor,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        SupportItem(
            icon = R.drawable.ic_contact_icon,
            mainText = "Contact",
            onclick = {}
        )
        SupportItem(
            icon = R.drawable.ic_instagram_icon,
            mainText = "Instagram",
            onclick = {}
        )
        SupportItem(
            icon = R.drawable.ic_twitter_icon,
            mainText = "Twitter",
            onclick = {}
        )
        SupportItem(
            icon = R.drawable.ic_facebook_icon,
            mainText = "Facebook",
            onclick = {}
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun SupportItem(
    icon: Int,
    mainText: String,
    onclick: () -> Unit
) {
    Card(
        onClick = {onclick()},
        backgroundColor = MaterialTheme.colors.cardUIBackground,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.padding(vertical = 2.5.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .size(45.dp)
                    .clip(shape = Shapes.medium)
                    .background(MaterialTheme.colors.cardUIBackground)
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "" ,
                        tint = MaterialTheme.colors.iconColor,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = mainText,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.titleTextColor,
                    fontSize = 15.sp
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = "",
                modifier = Modifier.size(34.dp)
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun GeneralSettingsItem(
    icon: Int,
    mainText: String,
    subText: String,
    onclick: () -> Unit
) {
    Card(
        onClick = { onclick() },
        backgroundColor = MaterialTheme.colors.cardUIBackground,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.padding(vertical = 2.5.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .size(45.dp)
                    .clip(shape = Shapes.medium)
                    .background(MaterialTheme.colors.cardUIBackground)
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "",
                        tint = MaterialTheme.colors.iconColor,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Column {
                    Text(
                        text = mainText,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = MaterialTheme.colors.titleTextColor
                    )
                    Text(
                        text = subText,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp,
                        color = MaterialTheme.colors.descriptionsTextColor,
                        modifier = Modifier.offset(y=(-4).dp)
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = "",
                modifier = Modifier.size(34.dp)
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun GeneralOptionsUI() {
    Column(
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .padding(top = 10.dp)
    ) {
        Text(
            text = "General",
            fontFamily = FontFamily.Default,
            color = MaterialTheme.colors.baseTitleTextColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        GeneralSettingsItem(
            R.drawable.texnodev_icon,
            "Texnodev",
            "Texnologiyanin maraqli terefi.",
            onclick = {}
        )

        GeneralSettingsItem(
            R.drawable.texnodev_icon,
            "Texnodev",
            "Texnologiyanin maraqli terefi.",
            onclick = {}
        )
    }
}

@Composable
fun ProfileCardUI() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(10.dp),
        backgroundColor = MaterialTheme.colors.cardUIBackground,
        elevation = 0.dp,
        shape = Shapes.large
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Check your Profile.",
                    fontFamily = FontFamily.Default,
                    color = MaterialTheme.colors.titleTextColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "texnodev.com@gmail.com",
                    fontSize = 12.5.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.descriptionsTextColor,
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.buttonColor
                    ),
                    contentPadding = PaddingValues(horizontal = 30.dp),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 2.dp
                    ),
                    shape = Shapes.medium
                ) {
                    Text(
                        text = "View",
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.titleTextColor,
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
fun HeadText(){
    Text(
        text = "Settings",
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.baseTitleTextColor,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 10.dp)
    )
}

@ExperimentalMaterialApi
@Preview
@Composable
fun SettingPreview(){
    Scaffold() {
        SettingsScreen()
    }
}