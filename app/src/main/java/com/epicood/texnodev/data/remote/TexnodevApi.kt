package com.epicood.texnodev.data.remote

import com.epicood.texnodev.domain.model.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface TexnodevApi {

    @GET("wp-json/wl/v1/posts")
    suspend fun getAllHeroes(): List<Post>

}