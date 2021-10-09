package com.faranjit.hilt.mvvm.features.home.domain

import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse
import com.faranjit.hilt.mvvm.features.home.data.response.Service

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class FakeHomeRepository : HomeRepository {

    override suspend fun getHomeFeed(): BaseResult<FeedResponse> =
        BaseResult.Success(
            FeedResponse(
                allServices = emptyList(),
                posts = emptyList(),
                popularServices = listOf(
                    Service(1, 1, "Service 1"),
                    Service(2, 2, "Service 1"),
                    Service(3, 3, "Service 1")
                )
            )
        )
}