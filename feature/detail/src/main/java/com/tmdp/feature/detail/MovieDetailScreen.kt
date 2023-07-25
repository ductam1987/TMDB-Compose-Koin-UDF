package com.tmdp.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.tmdp.feature.detail.view.BoxRateView
import com.tmdp.feature.detail.view.MovieCastView
import com.tmdp.feature.detail.view.MovieDetailBody
import com.tmdp.feature.detail.view.MovieReviewView
import com.tmdp.feature.detail.view.MovieVideoView
import org.koin.androidx.compose.koinViewModel

/**
 * Created by Tam Nguyen on 23/07/2023.
 */

@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = koinViewModel(),
    movieId: Int,
    navBack: () -> Unit
) {

    val context = LocalContext.current

    val movieDetail = movieDetailViewModel.movieDetailState.collectAsState()
    val movieCast = movieDetailViewModel.movieCastState.collectAsState()
    val movieVideos = movieDetailViewModel.movieVideoState.collectAsState()
    val movieReviews = movieDetailViewModel.movieReviewState.collectAsState()

    LaunchedEffect(Unit) {
        movieDetailViewModel.getMovieDetail(movieId = movieId)
    }

    LaunchedEffect(Unit) {
        movieDetailViewModel.getMovieCast(movieId = movieId)
    }

    LaunchedEffect(Unit) {
        movieDetailViewModel.getMovieVideo(movieId = movieId)
    }

    LaunchedEffect(Unit) {
        movieDetailViewModel.getMovieReview(movieId = movieId)
    }

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        movieDetail.value?.let { _movieDetail ->
            MovieDetailBody(_movieDetail) {
                navBack.invoke()
            }
        }

        BoxRateView()

        MovieCastView(movieCast.value?.cast ?: emptyList())

        MovieVideoView(listVideos = movieVideos.value?.results ?: emptyList()) { key ->
            movieDetailViewModel.openYoutubeApp(context = context, keyYoutube = key)
        }

        MovieReviewView(movieReviews.value?.results ?: emptyList())
    }
}
