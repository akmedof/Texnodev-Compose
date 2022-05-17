package com.epicood.texnodev.data.paging_source

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.epicood.texnodev.data.local.TexnodevDatabase
import com.epicood.texnodev.data.remote.TexnodevApi
import com.epicood.texnodev.domain.model.Post
import javax.inject.Inject

@ExperimentalPagingApi
class PostRemoteMediator @Inject constructor(
    private val texnodevApi: TexnodevApi,
    private val texnodevDatabase: TexnodevDatabase
) : RemoteMediator<Int, Post>() {

    private val postDao = texnodevDatabase.postDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Post>): MediatorResult {
        return try {
            val response = texnodevApi.getAllHeroes()
            Log.d("APIIII: ", response.toString())
            if (response.isNotEmpty()) {
                texnodevDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        postDao.deleteAllPosts()
                    }
                    postDao.addPosts(posts = response)
                }
            }
            MediatorResult.Success(true)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }


}