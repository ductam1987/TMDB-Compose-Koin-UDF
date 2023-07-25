package com.tmdp.feature.detail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmdb.core.model.Credits
import com.tmdb.core.model.MovieDetail
import com.tmdb.core.model.Reviews
import com.tmdb.core.model.Videos
import com.tmdb.core.network.CoroutineDispatchers
import com.tmdb.core.repos.MovieDetailRepository
import com.tmdb.core.ui.base.StateModel
import com.tmdb.core.ui.convertYoutubeUrl
import kotlinx.coroutines.launch

/**
 * Created by Tam Nguyen on 23/07/2023.
 */
class MovieDetailViewModel(
    private val movieDetailRepository: MovieDetailRepository,
    private val coroutineDispatchersIml: CoroutineDispatchers,
) : ViewModel() {

    val movieDetailState = StateModel<MovieDetail?>(null)
    val movieCastState = StateModel<Credits?>(null)
    val movieVideoState = StateModel<Videos?>(null)
    val movieReviewState = StateModel<Reviews?>(null)

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch(coroutineDispatchersIml.io) {
            movieDetailState.updateEvent(movieDetailRepository.getMovieDetail(movieId = movieId, apiKey = Constants.API_KEY))
        }
    }

    fun getMovieCast(movieId: Int) {
        viewModelScope.launch(coroutineDispatchersIml.io) {
            movieCastState.updateEvent(movieDetailRepository.getMovieCast(movieId = movieId, apiKey = Constants.API_KEY))
        }
    }

    fun getMovieVideo(movieId: Int) {
        viewModelScope.launch(coroutineDispatchersIml.io) {
            movieVideoState.updateEvent(movieDetailRepository.getMovieVideo(movieId = movieId, apiKey = Constants.API_KEY))
        }
    }

    fun getMovieReview(movieId: Int) {
        viewModelScope.launch(coroutineDispatchersIml.io) {
            val data = movieDetailRepository.getMovieReview(movieId = movieId, apiKey = Constants.API_KEY)
            Log.d("TAG", "___getMovieReview :::: $data")
            movieReviewState.updateEvent(data)
        }
    }

    fun openYoutubeApp(context: Context, keyYoutube: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setPackage("com.google.android.youtube")
        intent.data = Uri.parse(keyYoutube.convertYoutubeUrl())
        ContextCompat.startActivity(context, intent, null)
    }
}
