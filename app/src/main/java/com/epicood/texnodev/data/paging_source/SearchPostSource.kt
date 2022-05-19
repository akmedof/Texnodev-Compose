package com.epicood.texnodev.data.paging_source

import android.util.Log
import androidx.paging.*
import androidx.room.withTransaction
import com.epicood.texnodev.data.local.TexnodevDatabase
import com.epicood.texnodev.data.remote.TexnodevApi
import com.epicood.texnodev.domain.model.Post
import javax.inject.Inject

@ExperimentalPagingApi
class SearchPostSource @Inject constructor(
    private val texnodevDatabase: TexnodevDatabase,
    private val query: String
): RemoteMediator<Int, Post>() {

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Post>): MediatorResult {
        return try {
            val dao = texnodevDatabase.postDao()
            val response = dao.searchPosts(query)
            Log.d("APIIII: ", response.toString())
//            if (response.isNotEmpty()) {
//                texnodevDatabase.withTransaction {
//                    if (loadType == LoadType.REFRESH) {
//                        dao.deleteAllPosts()
//                    }
//                    postDao.addPosts(posts = response)
//                }
//            }
            MediatorResult.Success(true)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }
    //    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
//        return try {
//            val apiResponse = texnodevDatabase.postDao().searchPosts(query)
//            val posts = apiResponse
//            if (posts.isNotEmpty()){
//                LoadResult.Page(
//                    data = posts,
//                    prevKey = null,
//                    nextKey = null
//                )
//            }else {
//                LoadResult.Page(
//                    data = emptyList(),
//                    prevKey = null,
//                    nextKey = null
//                )
//            }
//        }catch (e: Exception){
//            LoadResult.Error(e)
//        }
//    }

}