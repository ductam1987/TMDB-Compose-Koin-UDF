package com.tmdb.core.ui.base

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.receiveAsFlow

/** Channels are used to handle events that must be processed exactly once.
 * This happens in a design with a type of event that usually has a single subscriber,
 * but intermittently (at startup or during some kind of reconfiguration) there are no subscribers at all,
 * and there is a requirement that all posted events must be retained until a subscriber appears.
 */

class SingleShotEventBus<T> {
    private val _events = Channel<T>(capacity = BUFFERED, onBufferOverflow = BufferOverflow.SUSPEND)
    val events = _events.receiveAsFlow() // expose as flow

    suspend fun updateEvent(event: T) {
        _events.send(event) // suspends on buffer overflow
    }

    suspend inline fun collect(crossinline action: suspend (T) -> Unit) {
        events.collect {
            action(it)
        }
    }

    @Composable
    fun collectAsState(initialValue: T) = events.collectAsStateWithLifecycle(initialValue = initialValue)
}
