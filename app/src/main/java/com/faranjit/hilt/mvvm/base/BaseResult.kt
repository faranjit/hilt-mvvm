package com.faranjit.hilt.mvvm.base

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
sealed class BaseResult<out R> {

    data class Success<out T>(val data: T) : BaseResult<T>()

    data class Error(val exception: Exception) : BaseResult<Nothing>()

    data class Loading(val showing: Boolean) : BaseResult<Nothing>()
}

/**
 * `true` if [BaseResult] is of type [Success] & holds non-null [Success.data].
 */
val BaseResult<*>.succeeded
    get() = this is BaseResult.Success && data != null
