package com.faranjit.hilt.mvvm.features.home.domain.model

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
data class FeedModel(
    val allServices: List<ServiceModel>,
    val popularServices: List<ServiceModel>,
    val posts: List<PostModel>
)

data class ServiceModel(
    val id: Int,
    val serviceId: Int,
    val name: String,
    val longName: String? = null,
    val imageUrl: String? = null,
    val proCount: Int? = 0
)

data class PostModel(
    val title: String,
    val category: String? = null,
    val imageUrl: String? = null,
    val link: String? = null,
)