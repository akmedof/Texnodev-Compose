package com.epicood.texnodev.presentation.screen.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.epicood.texnodev.data.local.dao.PostDao
import com.epicood.texnodev.domain.model.Post
import com.epicood.texnodev.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
//class SearchViewModel: ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _searchPosts = MutableStateFlow<PagingData<Post>>(PagingData.empty())
    val searchPosts = _searchPosts

    fun updateSearchQuery(query: String){
        _searchQuery.value = query
    }

    fun searchPosts(query: String){
        viewModelScope.launch(Dispatchers.IO) {
            useCases.searchPostsUseCase(query = query).cachedIn(viewModelScope).collect{
                _searchPosts.value = it
            }
        }
    }
}