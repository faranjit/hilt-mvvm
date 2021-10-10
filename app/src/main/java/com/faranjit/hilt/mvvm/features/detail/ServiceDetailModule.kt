package com.faranjit.hilt.mvvm.features.detail

import com.faranjit.hilt.mvvm.features.detail.data.ServiceDetailDataRepository
import com.faranjit.hilt.mvvm.features.detail.data.source.ServiceDetailRemoteDataSource
import com.faranjit.hilt.mvvm.features.detail.domain.ServiceDetailApi
import com.faranjit.hilt.mvvm.features.detail.domain.ServiceDetailRepository
import com.faranjit.hilt.mvvm.features.detail.domain.interactor.ServiceDetailResponseMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
@Module
@InstallIn(ActivityComponent::class)
object ServiceDetailModule {

    @Provides
    fun provideServiceDetailRemoteDataSource(
        detailApi: ServiceDetailApi,
        mapper: ServiceDetailResponseMapper
    ) =
        ServiceDetailRemoteDataSource(detailApi, mapper)
}

@Module
@InstallIn(SingletonComponent::class)
object ServiceDetailRepositoryModule {

    @Provides
    fun provideServiceDetailResponseMapper() = ServiceDetailResponseMapper

    @Singleton
    @Provides
    fun provideServiceDetailApi(retrofit: Retrofit): ServiceDetailApi =
        retrofit.create(ServiceDetailApi::class.java)

    @Singleton
    @Provides
    fun provideServiceDetailRepository(
        remoteDataSource: ServiceDetailRemoteDataSource,
        ioDispatcher: CoroutineDispatcher
    ): ServiceDetailRepository = ServiceDetailDataRepository(remoteDataSource, ioDispatcher)
}