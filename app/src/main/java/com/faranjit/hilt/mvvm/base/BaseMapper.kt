package com.faranjit.hilt.mvvm.base

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
abstract class BaseMapper<T, R> {

    abstract fun map(from: T): R
}

fun <T, R> T.map(mapper: (T) -> R) =
    BaseResult.Success(
        mapper(this)
    )