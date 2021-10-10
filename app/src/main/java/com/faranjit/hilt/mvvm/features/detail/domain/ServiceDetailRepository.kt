package com.faranjit.hilt.mvvm.features.detail.domain

import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.features.detail.domain.model.ServiceDetailModel

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
interface ServiceDetailRepository {

    suspend fun getServiceDetail(serviceId: Int): BaseResult<ServiceDetailModel>
}