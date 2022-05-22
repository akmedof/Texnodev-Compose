package com.epicood.texnodev.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.epicood.texnodev.R
import com.epicood.texnodev.ui.theme.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

private lateinit var conn: Document
private val list = ArrayList<String>()
private val list2 = ArrayList<String>()
private lateinit var x: Elements



@ExperimentalCoilApi
@Composable
fun ContentDescription(content: String){
    if (content.isNotEmpty()){
        GetHtml(html = content)
    }else ContentEmpty()
}

@Composable
fun ContentDescriptionDetails(desc: String){
    Box(
    ) {
        Text(text = desc,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.descriptionColor,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
        )
    }
}



@ExperimentalCoilApi
@Composable
fun ContentImageDetails(image: String){
    val painter = rememberImagePainter(data = image){
        placeholder(R.drawable.ic_empty_image)
        error(R.drawable.ic_empty_image)
        ColorFilter.tint(if (isSystemInDarkTheme()) LightGrey else DarkGrey)
    }
    Box(
        modifier = Modifier
            .height(POST_ITEM_HEIGHT)
            .padding(5.dp),
        contentAlignment = Alignment.BottomStart,
    ){
        Surface(
            shape = RoundedCornerShape(size = 5.dp)
        ) {
            Modifier.padding(10.dp)
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = stringResource(id = R.string.post_image),
                contentScale = ContentScale.Crop
            )
        }
    }
}



@ExperimentalCoilApi
@Composable
fun AddImageAndText() {
    for (l in list) {
        if (l.substring(0, 8) == "https://") {
//            l.replace("[\\\\\"]".toRegex(), "")
            println("Image: ${l.toString()}")
            ContentImageDetails(image = l)
        } else {
            println("Text: ${l.toString()}")
            ContentDescriptionDetails(l)
        }
    }
    list.clear()
}

@ExperimentalCoilApi
@Composable
fun GetHtml(html: String) {
        conn = Jsoup.parse(html)
        x = conn.select("img")
        val y: Elements = conn.select("p,img")
        val img = "<img src"
        val img2 = "geo_headline_2"
        for (k in y) {
            if (k.toString().substring(0, img.length) == img) {
                list.add(k.attr("src").replace("[\\\\\"]".toRegex(), ""))
            } else {
                list.add(k.text())
            }
            list2.add(k.toString())
        }
        AddImageAndText()
}

@Composable
fun ContentEmpty(){
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
            painter = painterResource(id = R.drawable.search_document),
            contentDescription = stringResource(R.string.network_error_icon),
            tint = if (isSystemInDarkTheme()) LightGrey else DarkGrey
        )
        Text(
            modifier = Modifier
                .padding(SMALE_PADDING),
            text = "Content Empty...",
            color = if (isSystemInDarkTheme()) LightGrey else DarkGrey,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.h4.fontSize
        )
    }
}



@ExperimentalCoilApi
@Preview
@Composable
fun ImagePreview() {
    ContentImageDetails(image = "")
}