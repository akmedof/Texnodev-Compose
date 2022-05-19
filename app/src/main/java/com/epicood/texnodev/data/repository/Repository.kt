package com.epicood.texnodev.data.repository

import android.util.Log
import androidx.paging.PagingData
import com.epicood.texnodev.domain.model.Post
import com.epicood.texnodev.domain.repository.DataStoreOperations
import com.epicood.texnodev.domain.repository.RemoteDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataStore,
    private val dataStore: DataStoreOperations
) {

    fun getAllPosts(): Flow<PagingData<Post>>{
        return remote.getAllPosts()
    }

    fun searchPosts(query: String): Flow<PagingData<Post>>{
        return remote.searchPosts(query)
    }

    suspend fun saveOnBoardingState(completed: Boolean){
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean>{
        return dataStore.readOnBoardingState()
    }

}