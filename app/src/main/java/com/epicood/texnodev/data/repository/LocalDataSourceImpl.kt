package com.epicood.texnodev.data.repository

import com.epicood.texnodev.data.local.TexnodevDatabase
import com.epicood.texnodev.domain.model.Post
import com.epicood.texnodev.domain.repository.LocalDataSource

class LocalDataSourceImpl(texnodevDatabase: TexnodevDatabase): LocalDataSource {

    private val postDao = texnodevDatabase.postDao()

    override suspend fun getSelectedPost(postId: Int): Post {
        return postDao.getPostById(postId = postId)
    }
}