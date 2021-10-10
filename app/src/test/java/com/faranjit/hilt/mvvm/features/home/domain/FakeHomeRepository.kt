package com.faranjit.hilt.mvvm.features.home.domain

import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.features.home.domain.model.FeedModel
import com.faranjit.hilt.mvvm.features.home.domain.model.PostModel
import com.faranjit.hilt.mvvm.features.home.domain.model.ServiceModel

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class FakeHomeRepository : HomeRepository {

    override suspend fun getHomeFeed(): BaseResult<FeedModel> =
        BaseResult.Success(
            FeedModel(
                allServices = listOf(
                    ServiceModel(4, 4, "Service 4"),
                    ServiceModel(5, 5, "Service 5"),
                    ServiceModel(6, 6, "Service 6")
                ),
                popularServices = listOf(
                    ServiceModel(1, 1, "Service 1"),
                    ServiceModel(2, 2, "Service 1"),
                    ServiceModel(3, 3, "Service 1")
                ),
                posts = listOf(
                    PostModel("Post 1", "Cat 1", "img 1", "link 1"),
                    PostModel("Post 2", "Cat 2", "img 2", "link 2"),
                    PostModel("Post 3", "Cat 3", "img 3", "link 3")
                ),
            )
        )
}