package com.faranjit.hilt.mvvm.features.home.data.source

import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.map
import com.faranjit.hilt.mvvm.features.home.domain.HomeApi
import com.faranjit.hilt.mvvm.features.home.domain.interactor.FeedResponseMapper
import com.faranjit.hilt.mvvm.features.home.domain.model.FeedModel
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class HomeRemoteDataSource @Inject constructor(
    private val homeApi: HomeApi,
    private val mapper: FeedResponseMapper
) {

    suspend fun getHomeFeed(): BaseResult<FeedModel> {
        return try {
            homeApi.getHomeFeed().map {
                mapper.map(it)
            }
        } catch (ex: Exception) {
            BaseResult.Error(ex)
        }
    }
}