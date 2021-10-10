package com.faranjit.hilt.mvvm.base

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
interface BaseMapper<T, R> {

    fun map(from: T): R
}

fun <T, R> T.map(mapper: (T) -> R) =
    BaseResult.Success(
        mapper(this)
    )