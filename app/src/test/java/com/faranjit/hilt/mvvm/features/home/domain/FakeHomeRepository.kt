package com.faranjit.hilt.mvvm.features.home.domain

import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse
import com.faranjit.hilt.mvvm.features.home.data.response.Post
import com.faranjit.hilt.mvvm.features.home.data.response.Service

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class FakeHomeRepository : HomeRepository {

    override suspend fun getHomeFeed(): BaseResult<FeedResponse> =
        BaseResult.Success(
            FeedResponse(
                allServices = listOf(
                    Service(4, 4, "Service 4"),
                    Service(5, 5, "Service 5"),
                    Service(6, 6, "Service 6")
                ),
                popularServices = listOf(
                    Service(1, 1, "Service 1"),
                    Service(2, 2, "Service 1"),
                    Service(3, 3, "Service 1")
                ),
                posts = listOf(
                    Post("Post 1", "Cat 1", "img 1", "link 1"),
                    Post("Post 2", "Cat 2", "img 2", "link 2"),
                    Post("Post 3", "Cat 3", "img 3", "link 3")
                ),
            )
        )
}