package com.faranjit.hilt.mvvm.base

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
sealed class BaseResult<out R> {

    data class Success<out T>(val data: T) : BaseResult<T>()

    data class Error(val exception: Exception) : BaseResult<Nothing>()

    data class Loading(val showing: Boolean) : BaseResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Loading -> "Loading"
        }
    }
}
