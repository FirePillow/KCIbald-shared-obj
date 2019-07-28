package com.kcibald.services

sealed class Result<T> {
    data class Success<T>(val result: T): Result<T>()
    object NotFound: Result<Any>()
    data class Failure<T>(val message: String): Result<T>()
}