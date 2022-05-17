package com.epicood.texnodev.presentation.common

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.epicood.texnodev.R
import com.epicood.texnodev.domain.model.Post
import com.epicood.texnodev.navigation.Screen
import com.epicood.texnodev.ui.theme.*

@ExperimentalCoilApi
@Composable
fun ListContent(
    posts: LazyPagingItems<Post>,
    navController: NavHostController
){
    Log.d("ListContent", posts.loadState.toString())
    LazyColumn(
        contentPadding = PaddingValues(SMALE_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALE_PADDING)
    ){
        items(
            items = posts,
            key = { post ->

                post.id
            }
        ){ post ->
            post?.let {
                PostItem(post = it, navController = navController)
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun PostItem(
    post: Post,
    navController: NavHostController
){
    Log.d("PostItem", post.title)

    val painter = rememberImagePainter(data = post.postImage){
        placeholder(R.drawable.spinnerlogo)
        error(R.drawable.spinnerlogo)
    }

    Box(
        modifier = Modifier
            .height(POST_ITEM_HEIGHT)
            .clickable {
                navController.navigate(Screen.Details.passPostId(postId = post.id))
            },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(
            shape = Shapes.large
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = stringResource(id = R.string.post_image),
                contentScale = ContentScale.Crop
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = MEDIUM_PADDING),
            ) {
                Text(
                    text = post.title,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = post.content,
                    color = Color.White.copy(ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}