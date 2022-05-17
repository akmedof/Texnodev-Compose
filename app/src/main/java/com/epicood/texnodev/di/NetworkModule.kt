package com.epicood.texnodev.di

import androidx.paging.ExperimentalPagingApi
import com.epicood.texnodev.data.local.TexnodevDatabase
import com.epicood.texnodev.data.remote.TexnodevApi
import com.epicood.texnodev.data.repository.RemoteDataStoreImpl
import com.epicood.texnodev.domain.repository.RemoteDataStore
import com.epicood.texnodev.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.MINUTES)
            .connectTimeout(15, TimeUnit.MINUTES)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient:OkHttpClient): Retrofit{
//        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory()
//            .addConverterFactory(Json.asConverterFactory(contentType = contentType))
            .build()

    }

    @Singleton
    @Provides
    fun provideTexnodevApi(retrofit: Retrofit): TexnodevApi{
        return retrofit.create(TexnodevApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        texnodevApi: TexnodevApi,
        texnodevDatabase: TexnodevDatabase
    ): RemoteDataStore{
        return RemoteDataStoreImpl(
            texnodevApi = texnodevApi,
            texnodevDatabase = texnodevDatabase
        )
    }

}