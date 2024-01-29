package com.hawary.poststask.data.repoImpl

import com.hawary.poststask.data.ApiResult
import com.hawary.poststask.data.network.PostService
import com.hawary.poststask.domain.models.PostDetails
import com.hawary.poststask.domain.models.PostResponse
import com.hawary.poststask.domain.repo.PostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val postService: PostService) :
    PostsRepository {
    override fun getPosts(): Flow<ApiResult<PostResponse>> = flow {
        val response = postService.getPosts()
        if (response.isSuccessful) {
            if (response.body() != null)
                emit(ApiResult.Success(response.body()!!))
            else
                emit(ApiResult.Error("No Data Found"))
        } else {
            emit(ApiResult.Error(response.message()))
        }
    }.catch { emit(ApiResult.Error( "Connection Error \n Check Internet Then Try Again")) }

    override fun getPostDetails(postId: String): Flow<ApiResult<PostDetails>> = flow {
        val response = postService.getPostDetails(postId)
        if (response.isSuccessful) {
            if (response.body() != null)
                emit(ApiResult.Success(response.body()!!))
            else
                emit(ApiResult.Error("No Data Found"))
        } else {
            emit(ApiResult.Error(response.message()))
        }
    }.catch { emit(ApiResult.Error( "Connection Error")) }
}