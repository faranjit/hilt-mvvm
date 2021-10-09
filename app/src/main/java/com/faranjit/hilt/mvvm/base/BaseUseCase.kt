package com.faranjit.hilt.mvvm.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
abstract class BaseUseCase<T, Params> {

    abstract suspend fun getData(params: Params?): BaseResult<T>

    suspend fun execute(params: Params? = null): Flow<BaseResult<T>> =
        flow {
            // show loading progress when request starts
            emit(BaseResult.Loading(true))

            // emit the actual result
            emit(getData(params))

            // hide loading progress when request finishes
            emit(BaseResult.Loading(false))
        }
}