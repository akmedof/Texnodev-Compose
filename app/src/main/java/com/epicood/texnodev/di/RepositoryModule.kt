package com.epicood.texnodev.di

import android.content.Context
import com.epicood.texnodev.data.repository.DataStoreOperationsImpl
import com.epicood.texnodev.data.repository.Repository
import com.epicood.texnodev.domain.repository.DataStoreOperations
import com.epicood.texnodev.domain.use_cases.UseCases
import com.epicood.texnodev.domain.use_cases.get_all_posts.GetAllPostsUseCase
import com.epicood.texnodev.domain.use_cases.get_selected_post.GetSelectedPostUseCase
import com.epicood.texnodev.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.epicood.texnodev.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.epicood.texnodev.domain.use_cases.search_posts.SearchPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context
    ): DataStoreOperations{
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases{
        return UseCases(
            saveOnBoardingState = SaveOnBoardingUseCase(repository = repository),
            readOnBoardingState = ReadOnBoardingUseCase(repository = repository),
            getAllPostsUseCase = GetAllPostsUseCase(repository = repository),
            searchPostsUseCase = SearchPostsUseCase(repository = repository),
            getSelectedPostUseCase = GetSelectedPostUseCase(repository = repository)
        )
    }

}