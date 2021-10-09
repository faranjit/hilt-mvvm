package com.faranjit.hilt.mvvm.features.home.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@Serializable
data class FeedResponse(
    @SerialName("all_services")
    val allServices: List<Service>,
    @SerialName("popular")
    val popularServices: List<Service>,
    @SerialName("posts")
    val posts: List<Post>
)

@Serializable
data class Service(
    @SerialName("id")
    val id: Int,
    @SerialName("service_id")
    val serviceId: Int,
    @SerialName("name")
    val name: String,
    @SerialName("long_name")
    val longName: String? = null,
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("pro_count")
    val proCount: Int? = 0,
    @SerialName("average_rating")
    val averageRating: Float? = 0f,
    @SerialName("completed_jobs_on_last_month")
    val jobCountOnLastMonth: Int? = 0
)

@Serializable
data class Post(
    @SerialName("title")
    val title: String,
    @SerialName("category")
    val category: String? = null,
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("link")
    val link: String? = null,
)