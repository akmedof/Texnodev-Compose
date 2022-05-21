package com.epicood.texnodev.domain.use_cases.get_selected_post

import com.epicood.texnodev.data.repository.Repository
import com.epicood.texnodev.domain.model.Post

class GetSelectedPostUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(postId: Int): Post{
        return repository.getSelectedPost(postId)
    }
}