package com.epicood.texnodev.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.epicood.texnodev.data.local.TexnodevDatabase
import com.epicood.texnodev.util.Constants.TEXNODEV_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) : TexnodevDatabase {
         return Room.databaseBuilder(
            context,
            TexnodevDatabase::class.java,
            TEXNODEV_DATABASE
        ).build()
    }

}