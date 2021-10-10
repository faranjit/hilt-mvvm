package com.faranjit.hilt.mvvm.features.detail.data

import com.faranjit.hilt.mvvm.features.detail.data.source.ServiceDetailRemoteDataSource
import com.faranjit.hilt.mvvm.features.detail.domain.ServiceDetailRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
class ServiceDetailDataRepository @Inject constructor(
    private val remoteDataSource: ServiceDetailRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ServiceDetailRepository {

    override suspend fun getServiceDetail(serviceId: Int) =
        withContext(ioDispatcher) {
            remoteDataSource.getServiceDetail(serviceId)
        }
}