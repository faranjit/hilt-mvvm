package com.faranjit.hilt.mvvm.features.home.data.source

import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse
import com.faranjit.hilt.mvvm.features.home.domain.HomeApi
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class HomeRemoteDataSource @Inject constructor(
    private val homeApi: HomeApi
) {

    suspend fun getHomeFeed(): BaseResult<FeedResponse> {
        return try {
            val response = homeApi.getHomeFeed()
            BaseResult.Success(response)
        } catch (ex: Exception) {
            BaseResult.Error(ex)
        }
    }
}