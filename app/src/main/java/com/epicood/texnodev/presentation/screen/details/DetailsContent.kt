package com.epicood.texnodev.presentation.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.epicood.texnodev.R
import com.epicood.texnodev.domain.model.Post
import com.epicood.texnodev.presentation.common.ContentDescription
import com.epicood.texnodev.presentation.common.DetailsArrowBackButton
import com.epicood.texnodev.presentation.common.DetailsFavoriteButton
import com.epicood.texnodev.ui.theme.*
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import kotlin.math.max
import kotlin.math.min

val AppBarCollapsedHeight = 80.dp
val AppBarExpendedHeight = 400.dp

@ExperimentalCoilApi
@Composable
fun DetailsContent(
    selectPost: Post?,
    onArrowBackClick: () -> Unit
) {
    val scrollState = rememberLazyListState()

    Box(
//        Modifier.background(MaterialTheme.colors.appBackground)
    ) {
        selectPost?.let { Contents(it, scrollState) }
        selectPost?.let { ProfileToolBar(it, onArrowBackClick, scrollState) }
    }
}

@ExperimentalCoilApi
@Composable
fun ProfileToolBar(
    selectPost: Post,
    onArrowBackClick: () -> Unit,
    scrollState: LazyListState
) {
    val imageHeight = AppBarExpendedHeight - AppBarCollapsedHeight

    val maxOffset = with(LocalDensity.current) {
        imageHeight.roundToPx()
    } - LocalWindowInsets.current.systemBars.layoutInsets.top

    val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)

    val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset

    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        modifier = Modifier
            .height(
                AppBarExpendedHeight
            )
            .offset {
                IntOffset(x = 0, y = -offset)
            },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {
        Column {
            Box(
                Modifier
                    .height(imageHeight)
                    .graphicsLayer {
                        alpha = 1f - offsetProgress
                    }
            ) {
                val painter = rememberImagePainter(data = selectPost.postImage){
                    placeholder(R.drawable.ic_empty_image)
                    error(R.drawable.ic_empty_image)
                    ColorFilter.tint(if (isSystemInDarkTheme()) LightGrey else DarkGrey)
                }
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
                        text = selectPost.categories,
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
//          Details Title
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppBarCollapsedHeight),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = selectPost.title,
                    fontSize = 21.sp,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
//                        .padding(horizontal = (10 + 28 * offsetProgress).dp)
                        .padding(
                            top = (0 + 2 * offsetProgress).dp,
                            bottom = (15 + 0 * offsetProgress).dp,
                            end = (7.5 + 28 * offsetProgress).dp,
                            start = (7.5 + 28 * offsetProgress).dp
                        )
                        .scale(1f - 0.25f * offsetProgress)
                )
            }
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(AppBarCollapsedHeight)
            .padding(horizontal = 16.dp)
    ) {
        DetailsArrowBackButton(onArrowBackClick)
        DetailsFavoriteButton()
    }
}

@Composable
fun ButtonIconz(
    onArrowBackClick: () -> Unit
){
    Button(
        onClick = { onArrowBackClick() },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Gray),
        elevation = ButtonDefaults.elevation(),
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back Arrow",
            modifier = Modifier
                .width(25.dp)
                .height(25.dp),
            tint = Color.Black
        )
    }
}

@ExperimentalCoilApi
@Composable
fun Contents(selectPost: Post, scrollState: LazyListState) {
    LazyColumn(contentPadding = PaddingValues(top = AppBarExpendedHeight), state = scrollState) {
        item {
            ContentDescription(content = selectPost.content)
        }
    }
}
