package com.hawary.poststask.data.network

import com.hawary.poststask.domain.models.PostDetails
import com.hawary.poststask.domain.models.PostResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {
    @GET("posts")
    suspend fun getPosts(): Response<PostResponse>

    @GET("posts/{id}")
    suspend fun getPostDetails(@Query("id") postId:String): Response<PostDetails>
}