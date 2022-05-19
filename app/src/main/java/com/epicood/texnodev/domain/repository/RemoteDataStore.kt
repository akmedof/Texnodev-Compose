package com.epicood.texnodev.domain.repository

import androidx.paging.PagingData
import com.epicood.texnodev.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface RemoteDataStore {
    fun getAllPosts(): Flow<PagingData<Post>>
    fun searchPosts(query: String): Flow<PagingData<Post>>
}