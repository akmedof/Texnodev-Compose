package com.epicood.texnodev.domain.repository

import com.epicood.texnodev.domain.model.Post

interface LocalDataSource {
    suspend fun getSelectedPost(postId: Int): Post
}