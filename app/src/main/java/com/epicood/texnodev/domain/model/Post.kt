package com.epicood.texnodev.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.epicood.texnodev.util.Constants.POST_DATABASE_TABLE
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

@Serializable()
@Entity(tableName = POST_DATABASE_TABLE)
data class Post(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("categories")
    val categories: String,
    @SerializedName("author_name")
    val authorName: String,
    @SerializedName("author_image")
    val authorImage: String,
    @SerializedName("medium")
    val postImage: String
)
