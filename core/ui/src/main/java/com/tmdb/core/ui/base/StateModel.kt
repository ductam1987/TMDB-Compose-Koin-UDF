package com.tmdb.core.ui.base

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest

/** A popular way to deal with buffer overflow is to drop the oldest events and retain only the most recent, newest events.
 * In particular, it is a great way to model state variables in an application. */

open class StateModel<T>(initState: T) {
    private val _state = MutableStateFlow(value = initState)
    val state = _state.asStateFlow() // read-only public view

    fun updateEvent(newValue: T) {
        _state.tryEmit(newValue)
    }

    val value get() = state.value

    suspend inline fun collect(crossinline action: suspend (T) -> Unit) {
        state.collect {
            action(it)
        }
    }

    suspend inline fun collectLatest(crossinline action: suspend (T) -> Unit) {
        state.collectLatest {
            action(it)
        }
    }

    @Composable
    fun collectAsState() = state.collectAsStateWithLifecycle()
}
