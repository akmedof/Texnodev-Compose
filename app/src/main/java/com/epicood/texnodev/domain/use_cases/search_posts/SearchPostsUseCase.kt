package com.epicood.texnodev.domain.use_cases.search_posts

import androidx.paging.PagingData
import com.epicood.texnodev.data.repository.Repository
import com.epicood.texnodev.domain.model.Post
import kotlinx.coroutines.flow.Flow

class SearchPostsUseCase(
    private val repository: Repository
) {

    operator fun invoke(query: String): Flow<PagingData<Post>>{
        return repository.searchPosts(query)
    }
}