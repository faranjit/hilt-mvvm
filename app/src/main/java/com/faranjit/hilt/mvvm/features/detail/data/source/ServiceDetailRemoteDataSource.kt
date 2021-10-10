package com.faranjit.hilt.mvvm.features.detail.data.source

import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.map
import com.faranjit.hilt.mvvm.features.detail.domain.ServiceDetailApi
import com.faranjit.hilt.mvvm.features.detail.domain.interactor.ServiceDetailResponseMapper
import com.faranjit.hilt.mvvm.features.detail.domain.model.ServiceDetailModel
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
class ServiceDetailRemoteDataSource @Inject constructor(
    private val detailApi: ServiceDetailApi,
    private val mapper: ServiceDetailResponseMapper
) {

    suspend fun getServiceDetail(serviceId: Int): BaseResult<ServiceDetailModel> {
        return try {
            val response = detailApi.getServiceDetail(serviceId)
            response.map {
                mapper.map(it)
            }
        } catch (ex: Exception) {
            BaseResult.Error(ex)
        }
    }
}