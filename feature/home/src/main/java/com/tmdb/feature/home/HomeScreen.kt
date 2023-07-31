package com.tmdb.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tmdb.core.model.db.DbMovie
import com.tmdb.core.model.fakeData.listDbMovieFakeData
import com.tmdb.core.model.fakeData.listGenreFakeData
import com.tmdb.core.model.fakeData.listMovieFakeData
import com.tmdb.core.model.network.Genre
import com.tmdb.core.model.network.Movie
import com.tmdb.feature.home.view.CategoryView
import com.tmdb.feature.home.view.PopularView
import com.tmdb.feature.home.view.RecommendationView
import com.tmdb.feature.home.view.TopRatedView
import com.tmdb.feature.home.view.UpcomingView
import org.koin.androidx.compose.koinViewModel
import theme.colorCrimson

/**
 * Created by Tam Nguyen on 17/07/2023.
 */

@Composable
fun HomeScreen(
    recommendViewModel: RecommendViewModel = koinViewModel(),
    navToMovieDetail: (Int) -> Unit,
) {

    val context = LocalContext.current

    /**
     * Movie Recommend
     */
    val moviesRecommendation = remember { mutableStateListOf<DbMovie>() }
    val totalMoviesRecommend: MutableState<Int> = remember { mutableStateOf(0) }
    val pagingMoviesRecommend = remember { mutableStateOf(1) }

    /**
     * Movie Gender
     */
    val genreList = recommendViewModel.genre.collectAsState()

    /**
     * Movie Popular
     */
    val moviesPopular = remember { mutableStateListOf<Movie>() }
    val totalMoviesPopular: MutableState<Int> = remember { mutableStateOf(0) }
    val pagingMoviesPopular = remember { mutableStateOf(1) }

    /**
     * Movie Top Rated
     */
    val moviesTopRated = remember { mutableStateListOf<Movie>() }
    val totalMoviesTopRated: MutableState<Int> = remember { mutableStateOf(0) }
    val pagingMoviesTopRated = remember { mutableStateOf(1) }

    /**
     * Movie Upcoming
     */
    val moviesUpcoming = remember { mutableStateListOf<Movie>() }
    val totalMoviesUpcoming: MutableState<Int> = remember { mutableStateOf(0) }
    val pagingMoviesUpcoming = remember { mutableStateOf(1) }

    /**
     * LaunchedEffect: Shouldn't call multiple functions inside LaunchEffect.
     * Each function should be run independently and is not affected by the other.
     * This provides better isolation and control over the execution flow.
     */

    LaunchedEffect(Unit) {
        recommendViewModel.getTMDBRecommend(paging = pagingMoviesRecommend.value) { _movies ->
            if (_movies?.listDbMovies?.isNotEmpty() == true) {
                moviesRecommendation.addAll(_movies.listDbMovies ?: emptyList())
                totalMoviesRecommend.value = _movies.totalResults ?: 0
            }
        }
    }

    LaunchedEffect(Unit) {
        recommendViewModel.getTMDBGender()
    }

    LaunchedEffect(Unit) {
        recommendViewModel.getTMDBPopular(paging = pagingMoviesPopular.value) { _movies ->
            if (_movies?.results?.isNotEmpty() == true) {
                moviesPopular.addAll(_movies.results)
                totalMoviesPopular.value = _movies.total_results
            }
        }
    }

    LaunchedEffect(Unit) {
        recommendViewModel.getTMDBTopRated(paging = pagingMoviesTopRated.value) { _movies ->
            if (_movies?.results?.isNotEmpty() == true) {
                moviesTopRated.addAll(_movies.results)
                totalMoviesTopRated.value = _movies.total_results
            }
        }
    }

    LaunchedEffect(Unit) {
        recommendViewModel.getTMDBUpcoming(paging = pagingMoviesUpcoming.value) { _movies ->
            if (_movies?.results?.isNotEmpty() == true) {
                moviesUpcoming.addAll(_movies.results)
                totalMoviesUpcoming.value = _movies.total_results
            }
        }
    }

    HomeScreenDetail(
        totalMoviesRecommend = totalMoviesRecommend,
        moviesRecommendation = moviesRecommendation,
        genreList = genreList.value?.genres ?: emptyList(),
        totalMoviesPopular = totalMoviesPopular,
        moviesPopular = moviesPopular,
        totalMoviesTopRated = totalMoviesTopRated,
        moviesTopRated = moviesTopRated,
        totalMoviesUpcoming = totalMoviesUpcoming,
        moviesUpcoming = moviesUpcoming,
        loadMoreRecommendation = {
            pagingMoviesRecommend.value += 1
            recommendViewModel.getTMDBRecommend(paging = pagingMoviesRecommend.value) { _movies ->
                if (_movies?.listDbMovies?.isNotEmpty() == true) {
                    moviesRecommendation.addAll(_movies.listDbMovies!!)
                }
            }
        },
        loadMorePopular = {
            pagingMoviesPopular.value += 1
            recommendViewModel.getTMDBPopular(paging = pagingMoviesPopular.value) { _movies ->
                if (_movies?.results?.isNotEmpty() == true) {
                    moviesPopular.addAll(_movies.results)
                }
            }
        },
        loadMoreTopRated = {
            pagingMoviesTopRated.value += 1
            recommendViewModel.getTMDBTopRated(paging = pagingMoviesTopRated.value) { _movies ->
                if (_movies?.results?.isNotEmpty() == true) {
                    moviesTopRated.addAll(_movies.results)
                }
            }
        },
        loadMoreUpcoming = {
            pagingMoviesUpcoming.value += 1
            recommendViewModel.getTMDBUpcoming(paging = pagingMoviesUpcoming.value) { _movies ->
                if (_movies?.results?.isNotEmpty() == true) {
                    moviesUpcoming.addAll(_movies.results)
                }
            }
        },
        navToMovieDetail = navToMovieDetail
    )
}

@Composable
fun HomeScreenDetail(
    totalMoviesRecommend: MutableState<Int>,
    moviesRecommendation: List<DbMovie>,
    genreList: List<Genre>? = emptyList(),
    totalMoviesPopular: MutableState<Int>,
    moviesPopular: List<Movie>,
    totalMoviesTopRated: MutableState<Int>,
    moviesTopRated: List<Movie>,
    totalMoviesUpcoming: MutableState<Int>,
    moviesUpcoming: List<Movie>,
    loadMoreRecommendation: () -> Unit,
    loadMorePopular: () -> Unit,
    loadMoreTopRated: () -> Unit,
    loadMoreUpcoming: () -> Unit,
    navToMovieDetail: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Box(
            modifier = Modifier
                .height(45.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "TMDB COMPOSE",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 25.sp,
                color = colorCrimson,
                fontWeight = FontWeight.Bold
            )
        }

        RecommendationView(
            totalMoviesRecommend = totalMoviesRecommend, movies = moviesRecommendation,
            navToMovieDetail = {
                navToMovieDetail.invoke(it)
            },
            loadMore = {
                loadMoreRecommendation.invoke()
            }
        )

        CategoryView(listGenre = genreList ?: emptyList())

        PopularView(
            totalMoviesPopular = totalMoviesPopular, movies = moviesPopular,
            navToMovieDetail = {
                navToMovieDetail.invoke(it)
            },
            loadMore = {
                loadMorePopular.invoke()
            }
        )

        TopRatedView(
            totalMoviesTopRated = totalMoviesTopRated, movies = moviesTopRated,
            navToMovieDetail = {
                navToMovieDetail.invoke(it)
            },
            loadMore = {
                loadMoreTopRated.invoke()
            }
        )

        UpcomingView(
            totalMoviesUpcoming = totalMoviesUpcoming, movies = moviesUpcoming,
            navToMovieDetail = {
                navToMovieDetail.invoke(it)
            },
            loadMore = {
                loadMoreUpcoming.invoke()
            }
        )
    }
}

@Preview
@Composable
fun PreviewHomeDetailScreen() {
    val totalMoviesRecommend: MutableState<Int> = remember { mutableStateOf(100) }
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        HomeScreenDetail(
            totalMoviesRecommend = totalMoviesRecommend,
            moviesRecommendation = listDbMovieFakeData,
            genreList = listGenreFakeData,
            totalMoviesPopular = totalMoviesRecommend,
            moviesPopular = listMovieFakeData,
            totalMoviesTopRated = totalMoviesRecommend,
            moviesTopRated = listMovieFakeData,
            totalMoviesUpcoming = totalMoviesRecommend,
            moviesUpcoming = listMovieFakeData,
            loadMoreRecommendation = { /*TODO*/ },
            loadMorePopular = { /*TODO*/ },
            loadMoreTopRated = { /*TODO*/ },
            loadMoreUpcoming = { /*TODO*/ },
            navToMovieDetail = {}
        )
    }
}
