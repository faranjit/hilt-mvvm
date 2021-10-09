package com.faranjit.hilt.mvvm.features.home.domain

import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
interface HomeRepository {

    suspend fun getHomeFeed(): BaseResult<FeedResponse>
}