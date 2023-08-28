package com.tmdb.feature.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
// import com.tmdb.core.model.fakeData.listMovieFakeData
// import com.tmdb.core.model.fakeData.movieFakeData4
import com.tmdb.core.model.network.Movie
import com.tmdb.core.ui.DevicePreviews
import com.tmdb.core.ui.MovieVerticalView
import com.tmdb.core.ui.OnLastItemReached
import com.tmdb.core.ui.TitleView
import com.tmdb.core.ui.dataTest.HomeFakeDataPreviewUI
import com.tmdb.core.ui.dataTest.HomePreviewParameterProvider
import com.tmdb.feature.recommend.R

/**
 * Created by Tam Nguyen on 20/07/2023.
 */

@Composable
fun TopRatedView(
    totalMoviesTopRated: MutableState<Int>,
    movies: List<Movie>,
    navToMovieDetail: (Int) -> Unit?,
    loadMore: () -> Unit
) {
    Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)) {

        TitleView(stringResourceId = R.string.top_rated, imgResourceId = R.drawable.ic_arrow_right)

        val listState = rememberLazyListState()
        LazyRow(
            state = listState,
            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
        ) {
            items(
                count = movies.distinct().size,
                key = { index ->
                    movies.distinct()[index].id
                }
            ) { index ->
                TopRatedViewDetail(movies.distinct()[index], navToMovieDetail)
            }
        }

        listState.OnLastItemReached {
            if (movies.isNotEmpty() && movies.distinct().size < totalMoviesTopRated.value) {
                loadMore.invoke()
            }
        }
    }
}

@Composable
fun TopRatedViewDetail(movie: Movie, navToMovieDetail: (Int) -> Unit?) {
    MovieVerticalView(movieImg = movie.poster_path, movieName = movie.title, movieId = movie.id, navToMovieDetail)
}

@DevicePreviews
@Composable
fun PreviewTopRatedView(
    @PreviewParameter(HomePreviewParameterProvider::class) homeFakeDataPreviewUI: HomeFakeDataPreviewUI,
) {
    val total = remember { mutableStateOf(5) }
    TopRatedView(totalMoviesTopRated = total, movies = homeFakeDataPreviewUI.listMovieFakeDataPreviewUI, navToMovieDetail = {}) {}
}

@DevicePreviews
@Composable
fun PreviewTopRatedViewDetail(
    @PreviewParameter(HomePreviewParameterProvider::class) homeFakeDataPreviewUI: HomeFakeDataPreviewUI,
) {
    TopRatedViewDetail(movie = homeFakeDataPreviewUI.listMovieFakeDataPreviewUI[0]) {}
}
