package com.hawary.poststask.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hawary.poststask.data.ApiResult
import com.hawary.poststask.domain.models.PostResponse
import com.hawary.poststask.domain.useCases.GetPosts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PostsViewModel @Inject constructor(private val getPosts: GetPosts):ViewModel() {
    private val mutablePosts:MutableLiveData<ApiResult<PostResponse>> = MutableLiveData()
    val posts: LiveData<ApiResult<PostResponse>> get() = mutablePosts

    fun getPosts(){
        viewModelScope.launch(Dispatchers.IO) {
            mutablePosts.postValue(ApiResult.Loading())
            Log.d("PostsViewModel", "getPosts: ${this.coroutineContext} ")
            getPosts.invoke().collect{
                mutablePosts.postValue(it)
            }
        }
    }
}