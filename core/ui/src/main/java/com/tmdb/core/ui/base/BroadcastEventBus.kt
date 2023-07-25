package com.tmdb.core.ui.base

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/** A shared flow exists regardless of whether it is being collected or not.
 * A collector of the shared flow is called a subscriber.
 * All subscribers of a shared flow receive the same sequence of values.
 * It effectively works like a “broadcast channel”, without most of the channel overhead */
class BroadcastEventBus<T> {
    private val _events = MutableSharedFlow<T>() // private mutable shared flow
    val events = _events.asSharedFlow() // read-only public view, publicly exposed as read-only shared flow

    suspend fun updateEvent(event: T) {
        _events.emit(event) // suspends until subscribers receive it
    }

    val value get() = _events

    suspend inline fun collect(crossinline action: suspend (T) -> Unit) {
        events.collect {
            action(it)
        }
    }

    @Composable
    fun collectAsState(initialValue: T) = events.collectAsStateWithLifecycle(initialValue = initialValue)
}
