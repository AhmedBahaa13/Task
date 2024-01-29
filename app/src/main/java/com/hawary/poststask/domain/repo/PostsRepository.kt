package com.hawary.poststask.domain.repo

import com.hawary.poststask.data.ApiResult
import com.hawary.poststask.domain.models.PostDetails
import com.hawary.poststask.domain.models.PostResponse
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getPosts(): Flow<ApiResult<PostResponse>>

    fun getPostDetails(postId:String):Flow<ApiResult<PostDetails>>
}
