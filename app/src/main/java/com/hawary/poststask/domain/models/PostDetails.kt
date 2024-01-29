package com.hawary.poststask.domain.models

data class PostDetails(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)