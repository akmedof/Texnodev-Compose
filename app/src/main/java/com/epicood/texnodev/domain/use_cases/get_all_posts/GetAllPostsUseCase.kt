package com.epicood.texnodev.domain.use_cases.get_all_posts

import androidx.paging.PagingData
import com.epicood.texnodev.data.repository.Repository
import com.epicood.texnodev.domain.model.Post
import kotlinx.coroutines.flow.Flow

class GetAllPostsUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Post>>{
        return repository.getAllPosts()
    }
}