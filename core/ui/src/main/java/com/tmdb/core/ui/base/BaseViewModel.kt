package com.tmdb.core.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.UUID
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {
    data class EventState<T>(
        val id: String = UUID.randomUUID().toString(),
        val eventValue: T,
    )

    var job = Job()
        get() {
            if (field.isCancelled) field = Job()
            return field
        }
    val handlerError = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
    }

    inline fun launchOnViewModelScope(scope: CoroutineContext, crossinline block: suspend () -> Unit) {
        viewModelScope.launch(context = viewModelScope.coroutineContext + scope + handlerError + job) {
            block()
        }
    }

    inline fun launchOnViewModelScopeSocket(scope: CoroutineContext, crossinline block: suspend () -> Unit) {
        viewModelScope.launch(context = viewModelScope.coroutineContext + scope + handlerError) {
            block()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
