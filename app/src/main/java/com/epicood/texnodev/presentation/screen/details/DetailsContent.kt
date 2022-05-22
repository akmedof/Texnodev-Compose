package com.epicood.texnodev.presentation.screen.details

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.epicood.texnodev.R
import com.epicood.texnodev.domain.model.Post
import com.epicood.texnodev.ui.theme.*
import com.google.accompanist.insets.LocalWindowInsets
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.math.max
import kotlin.math.min


@ExperimentalCoilApi
@Composable
fun DetailsContent(
    navController: NavHostController,
    selectedPost: Post?
){
    Scaffold(
        content = {
            selectedPost?.let { it1 -> DetailsUI(navController = navController, post = it1) }
        }
    )
}

@ExperimentalCoilApi
@Composable
fun DetailsUI(
    navController: NavHostController,
    post: Post
){
    val scrollState = rememberLazyListState()
    Box {
        ParallaxTolBar(post = post, scrollState = scrollState)
        Content(post = post, scrollState = scrollState)
    }
}

@ExperimentalCoilApi
@Composable
fun ParallaxTolBar(post: Post, scrollState: LazyListState){
    val imageHeight = POST_ITEM_DETAILS_HEIGHT - 80.dp

    val maxOffset = with(LocalDensity.current)
    {imageHeight.roundToPx()} - LocalWindowInsets.current.systemBars.top

    val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)

    val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset


    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        modifier = Modifier
            .height(POST_ITEM_DETAILS_HEIGHT)
            .offset { IntOffset(x = 0, y = -offset) },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {

        val painter = rememberImagePainter(data = post.postImage){
            placeholder(R.drawable.ic_empty_image)
            error(R.drawable.ic_empty_image)
            ColorFilter.tint(if (isSystemInDarkTheme()) LightGrey else DarkGrey)
        }

        Column {
            Box(
                Modifier
                    .height(imageHeight)
                    .graphicsLayer {
                        alpha = 1f - offsetProgress
                    }
            ) {
               Image(
                   painter = painter,
                   contentDescription = "Post Image",
                   contentScale = ContentScale.Crop,
                   modifier = Modifier.fillMaxSize()
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colorStops = arrayOf(
                                Pair(0.4f, Color.Transparent),
                                Pair(1f, Color.Black))))
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = post.categories,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colors.topAppBarContentColor,
                        modifier = Modifier
                            .clip(Shapes.small)
                            .background(MaterialTheme.colors.topAppBarBackgroundColor)
                            .padding(vertical = 6.dp, horizontal = 16.dp)
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_watch_icon),
                            contentDescription = "Watch Icon",
                            tint = MaterialTheme.colors.topAppBarContentColor,
                            modifier = Modifier.height(25.dp)
                        )
                        Text(
                            text = "15 dq əvvəl",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.topAppBarContentColor
                        )
                    }
                }
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .height(TOP_APP_BAR_HEIGHT),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = post.title,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    modifier = Modifier.padding(
                        top = (5 + 5 * offsetProgress).dp,
                        bottom = (5 + 20 * offsetProgress).dp,
                        start = (10 + 60 * offsetProgress).dp,
                        end = (5 + 60 * offsetProgress).dp
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT)
            .padding(horizontal = 16.dp)
    ) {
        CircularButton(R.drawable.ic_arrow_back)
        CircularButton(R.drawable.ic_favorite)
    }
}

@Composable
fun CircularButton(
    @DrawableRes icon: Int,
    color: Color = LightGrey,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    onClick: () -> Unit = {}
){
    Button(
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(),
        shape = Shapes.small,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
            contentColor = MaterialTheme.colors.topAppBarContentColor
        ),
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "")
    }
}

@Composable
fun Content(post: Post, scrollState: LazyListState){
    LazyColumn(
        contentPadding = PaddingValues(top = POST_ITEM_DETAILS_HEIGHT),
        state = scrollState
    ){
        item {
            Description(content = post.content)
        }
    }
}

@Composable
fun Description(content: String){
    Text(text = content,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colors.descriptionColor,
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
    )
}

@ExperimentalCoilApi
@Composable
@Preview
fun DetailsScreenPreview(){
//    DetailsContent(
////        {}, Post()
//    )
}