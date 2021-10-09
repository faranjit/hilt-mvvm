package com.faranjit.hilt.mvvm.features.home

import com.faranjit.hilt.mvvm.features.home.data.HomeDataRepository
import com.faranjit.hilt.mvvm.features.home.data.source.HomeRemoteDataSource
import com.faranjit.hilt.mvvm.features.home.domain.HomeApi
import com.faranjit.hilt.mvvm.features.home.domain.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@Module
@InstallIn(ActivityComponent::class)
object HomeModule {

    @Provides
    fun provideHomeRemoteDataSource(homeApi: HomeApi) = HomeRemoteDataSource(homeApi)
}

@Module
@InstallIn(SingletonComponent::class)
object HomeRepositoryModule {

    @Singleton
    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApi =
        retrofit.create(HomeApi::class.java)

    @Singleton
    @Provides
    fun provideHomeRepository(
        remoteDataSource: HomeRemoteDataSource,
        ioDispatcher: CoroutineDispatcher
    ): HomeRepository = HomeDataRepository(remoteDataSource, ioDispatcher)
}