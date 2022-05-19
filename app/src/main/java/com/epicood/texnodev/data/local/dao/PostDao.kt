package com.epicood.texnodev.data.local.dao

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.*
import com.epicood.texnodev.domain.model.Post

@Dao
interface PostDao {

//    @Query("SELECT * FROM post_table ORDER BY id ASC")
    @Query("SELECT * FROM post_table ORDER BY id DESC")
    fun getAllPost(): PagingSource<Int, Post>

    @Query("SELECT * FROM post_table WHERE title OR content LIKE '%' || :searchQuery || '%' ORDER BY id DESC")
    fun searchPosts(searchQuery: String): PagingSource<Int, Post>

    @Query("SELECT * FROM post_table WHERE id = :postId")
    fun getPostById(postId: Int): Post

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPosts(posts: List<Post>)

    @Query("DELETE FROM post_table")
    suspend fun deleteAllPosts()

}