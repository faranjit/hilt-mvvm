package com.faranjit.hilt.mvvm.features.detail.domain.interactor

import com.faranjit.hilt.mvvm.base.BaseMapper
import com.faranjit.hilt.mvvm.features.detail.data.response.ServiceDetailResponse
import com.faranjit.hilt.mvvm.features.detail.domain.model.ServiceDetailModel

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
object ServiceDetailResponseMapper : BaseMapper<ServiceDetailResponse, ServiceDetailModel> {

    override fun map(from: ServiceDetailResponse) =
        ServiceDetailModel(
            id = from.id,
            serviceId = from.serviceId,
            name = from.name,
            longName = from.longName,
            imageUrl = from.imageUrl,
            proCount = from.proCount,
            averageRating = from.averageRating,
            jobCountOnLastMonth = from.jobCountOnLastMonth
        )
}