package com.tmdb.core.ui.network

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.getOrElse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.suspendOnError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import retrofit2.Response

/**
 * Created by Tam Nguyen on 27/07/2023.
 */
abstract class NetworkBoundRepository<RESULT, REQUEST> {

    fun asFlow() = flow<ResultData<RESULT>> {

        emit(ResultData.SuccessLocal(fetchFromLocal().first()))

        // Fetch latest posts from remote
        val apiResponse = fetchFromRemote()

        // Parse body
        val remotePosts = apiResponse.getOrElse(null)

        // Check for response validation
        if (remotePosts != null) {
            // Save posts into the persistence storage
            saveRemoteData(remotePosts)
        } else {
            // Something went wrong! Emit Error state.
//            emit(ResultData.Error(status = apiResponse.suspendOnError { this.errorBody. }, message = apiResponse.message()))
        }
        // Retrieve posts from persistence storage and emit
        emitAll(
            fetchFromLocal().map {
                ResultData.SuccessMerged(it)
            },
        )
    }
        .onStart { // Emit Loading State
            emit(ResultData.Loading)
        }
        .catch { e ->
            emit(ResultData.Error(throwable = e))
            e.printStackTrace()
        }

    /**
     * Saves retrieved from remote into the persistence storage.
     */
    @WorkerThread
    protected abstract suspend fun saveRemoteData(response: REQUEST)

    /**
     * Retrieves all data from persistence storage.
     */
    @MainThread
    protected abstract suspend fun fetchFromLocal(): Flow<RESULT>

    /**
     * Fetches [Response] from the remote end point.
     */
    @MainThread
    protected abstract suspend fun fetchFromRemote(): ApiResponse<REQUEST>
}