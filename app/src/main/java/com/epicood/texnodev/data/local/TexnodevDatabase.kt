package com.epicood.texnodev.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.epicood.texnodev.data.local.dao.PostDao
import com.epicood.texnodev.domain.model.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class TexnodevDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

}