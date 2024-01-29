package com.hawary.poststask.domain.useCases

import com.hawary.poststask.data.ApiResult
import com.hawary.poststask.domain.models.PostResponse
import com.hawary.poststask.domain.repo.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPosts @Inject constructor(private val postsRepository: PostsRepository) {

    operator fun invoke(): Flow<ApiResult<PostResponse>> = postsRepository.getPosts()

}