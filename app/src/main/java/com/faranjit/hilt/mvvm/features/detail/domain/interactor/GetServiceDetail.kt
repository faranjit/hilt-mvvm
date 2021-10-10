package com.faranjit.hilt.mvvm.features.detail.domain.interactor

import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.BaseUseCase
import com.faranjit.hilt.mvvm.features.detail.domain.ServiceDetailRepository
import com.faranjit.hilt.mvvm.features.detail.domain.model.ServiceDetailModel
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
class GetServiceDetail @Inject constructor(
    private val serviceDetailRepository: ServiceDetailRepository
) : BaseUseCase<ServiceDetailModel, GetServiceDetail.Params>() {

    override suspend fun getData(params: Params?): BaseResult<ServiceDetailModel> =
        params?.let {
            serviceDetailRepository.getServiceDetail(params.serviceId)
        } ?: run {
            BaseResult.Error(Exception("The service that you requested could not found!"))
        }

    data class Params(
        val serviceId: Int
    )
}