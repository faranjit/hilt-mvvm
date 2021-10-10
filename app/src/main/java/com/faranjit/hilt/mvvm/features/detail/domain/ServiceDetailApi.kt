package com.faranjit.hilt.mvvm.features.detail.domain

import com.faranjit.hilt.mvvm.features.detail.data.response.ServiceDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
interface ServiceDetailApi {

    @GET("service/{serviceId}")
    suspend fun getServiceDetail(@Path("serviceId") serviceId: Int): ServiceDetailResponse
}