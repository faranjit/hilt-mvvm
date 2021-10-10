package com.faranjit.hilt.mvvm.features.detail.domain.model

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
data class ServiceDetailModel(
    val id: Int,
    val serviceId: Int,
    val name: String,
    val longName: String? = null,
    val imageUrl: String? = null,
    val proCount: Int? = 0,
    val averageRating: Float? = 0f,
    val jobCountOnLastMonth: Int? = 0
)