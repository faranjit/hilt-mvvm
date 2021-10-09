package com.faranjit.hilt.mvvm.features.home.domain

import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse
import retrofit2.http.GET

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
interface HomeApi {

    @GET("home")
    @Throws(Exception::class)
    suspend fun getHomeFeed(): FeedResponse
}