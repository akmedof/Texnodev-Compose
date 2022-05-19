package com.epicood.texnodev.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.epicood.texnodev.data.local.TexnodevDatabase
import com.epicood.texnodev.data.paging_source.PostRemoteMediator
import com.epicood.texnodev.data.paging_source.SearchPostSource
import com.epicood.texnodev.data.remote.TexnodevApi
import com.epicood.texnodev.domain.model.Post
import com.epicood.texnodev.domain.repository.RemoteDataStore
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataStoreImpl(
    private val texnodevApi: TexnodevApi,
    private val texnodevDatabase: TexnodevDatabase
): RemoteDataStore {

    private val postDao = texnodevDatabase.postDao()

    override fun getAllPosts(): Flow<PagingData<Post>> {
        val pagingSourceFactory = {postDao.getAllPost()}
        return Pager(
            config = PagingConfig(3),
            remoteMediator = PostRemoteMediator(
                texnodevApi = texnodevApi,
                texnodevDatabase = texnodevDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchPosts(query: String): Flow<PagingData<Post>> {
        val pagingSourceFactory = {postDao.searchPosts(query)}
        return Pager(
            config = PagingConfig(3),
            remoteMediator = PostRemoteMediator(
                texnodevApi = texnodevApi,
                texnodevDatabase = texnodevDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}