package com.hawary.poststask.domain.useCases

import com.hawary.poststask.data.ApiResult
import com.hawary.poststask.domain.models.PostDetails
import com.hawary.poststask.domain.repo.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostDetails @Inject constructor(val postsRepository: PostsRepository) {

    operator fun invoke(postId: String): Flow<ApiResult<PostDetails>> =
        postsRepository.getPostDetails(postId)

}