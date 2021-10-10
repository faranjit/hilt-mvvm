package com.faranjit.hilt.mvvm.features.home.domain.interactor

import com.faranjit.hilt.mvvm.base.BaseMapper
import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse
import com.faranjit.hilt.mvvm.features.home.domain.model.FeedModel

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
object FeedResponseMapper : BaseMapper<FeedResponse, FeedModel>() {

    override fun map(from: FeedResponse) = from.toModel()
}