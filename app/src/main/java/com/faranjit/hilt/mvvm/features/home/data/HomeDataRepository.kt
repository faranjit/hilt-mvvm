package com.faranjit.hilt.mvvm.features.home.data

import com.faranjit.hilt.mvvm.features.home.data.source.HomeRemoteDataSource
import com.faranjit.hilt.mvvm.features.home.domain.HomeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class HomeDataRepository @Inject constructor(
    private val remoteDataSource: HomeRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HomeRepository {

    override suspend fun getHomeFeed() =
        withContext(ioDispatcher) {
            remoteDataSource.getHomeFeed()
        }
}