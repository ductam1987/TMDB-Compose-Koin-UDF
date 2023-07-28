package com.tmdb.core.ui.network

/**
 * Created by Tam Nguyen on 27/07/2023.
 */
sealed interface ResultData<out T> {
    object Loading : ResultData<Nothing>
    data class SuccessLocal<out T>(val data: T? = null) : ResultData<T>
    data class SuccessMerged<out T>(val data: T? = null) : ResultData<T>
    data class Error(val throwable: Throwable? = null, val exception: Exception? = null, val status: Int? = null, val message: String? = null) : ResultData<Nothing>
}

sealed interface Resource<T> {
    data class Success<T>(val data: T? = null) : Resource<T>
    data class Failed<T>(val throwable: Throwable? = null, val exception: Exception? = null, val message: String? = null) : Resource<T>
}