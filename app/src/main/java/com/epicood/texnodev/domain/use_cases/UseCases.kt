package com.epicood.texnodev.domain.use_cases

import com.epicood.texnodev.domain.use_cases.get_all_posts.GetAllPostsUseCase
import com.epicood.texnodev.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.epicood.texnodev.domain.use_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingState: SaveOnBoardingUseCase,
    val readOnBoardingState: ReadOnBoardingUseCase,
    val getAllPostsUseCase: GetAllPostsUseCase
)
