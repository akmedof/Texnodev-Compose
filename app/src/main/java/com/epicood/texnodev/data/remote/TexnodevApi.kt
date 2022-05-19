package com.epicood.texnodev.data.remote

import com.epicood.texnodev.domain.model.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface TexnodevApi {

    @GET("wp-json/wl/v1/posts")
    suspend fun getAllHeroes(): List<Post>

    @GET("wp-json/wp/v2/posts?search=")
    suspend fun searchPosts(
        @Query("name") name: String
    ): List<Post>

}