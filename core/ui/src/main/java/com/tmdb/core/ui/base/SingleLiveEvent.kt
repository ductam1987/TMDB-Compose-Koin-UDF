package com.tmdb.core.ui.base

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Created by Tam Nguyen on 07/07/2023.
 */
class SingleLiveEvent<T> {

    private val _events = Channel<T>(capacity = Channel.BUFFERED, onBufferOverflow = BufferOverflow.SUSPEND)
    val events = _events.receiveAsFlow() // expose as flow
    var cachedData: T? = null

    suspend fun updateEvent(event: T) {
        _events.send(event) // suspends on buffer overflow
    }

    val value get() = cachedData

    suspend inline fun collect(crossinline action: suspend (T) -> Unit) {
        events.collect {
            cachedData = it
            action(it)
        }
    }
}
