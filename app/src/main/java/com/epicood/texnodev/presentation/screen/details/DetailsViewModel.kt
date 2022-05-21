package com.epicood.texnodev.presentation.screen.details

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epicood.texnodev.domain.model.Post
import com.epicood.texnodev.domain.use_cases.UseCases
import com.epicood.texnodev.util.Constants.DETAILS_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _selectedPost: MutableStateFlow<Post?> = MutableStateFlow(null)
    val selectedPost: StateFlow<Post?> = _selectedPost

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val postId = savedStateHandle.get<Int>(DETAILS_ARGUMENT_KEY)
            _selectedPost.value = postId?.let { useCases.getSelectedPostUseCase(postId) }
        }
    }
}

