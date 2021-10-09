package com.faranjit.hilt.mvvm.features.home.domain.interactor

import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.BaseUseCase
import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse
import com.faranjit.hilt.mvvm.features.home.domain.HomeRepository
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class GetHomeFeed @Inject constructor(
    private val homeRepository: HomeRepository
) : BaseUseCase<FeedResponse, Unit>() {

    override suspend fun getData(params: Unit?): BaseResult<FeedResponse> =
        homeRepository.getHomeFeed()
}