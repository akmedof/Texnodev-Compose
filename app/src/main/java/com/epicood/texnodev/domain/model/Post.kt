package com.epicood.texnodev.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.epicood.texnodev.util.Constants.POST_DATABASE_TABLE

@Entity(tableName = POST_DATABASE_TABLE)
data class Post(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val date: String,
    val content: String,
    val categories: String,
    val authorName: String,
    val authorImage: String,
    val postImage: String
)
