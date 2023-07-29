package com.tmdb.feature.home.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tmdb.core.model.db.DbMovie
import com.tmdb.core.model.fakeData.listDbMovieFakeData
import com.tmdb.core.ui.LoadImage
import com.tmdb.core.ui.OnLastItemReached
import com.tmdb.core.ui.TitleView
import com.tmdb.core.ui.convertImageURL
import com.tmdb.feature.recommend.R

/**
 * Created by Tam Nguyen on 16/07/2023.
 */

@Composable
fun RecommendationView(
    totalMoviesRecommend: MutableState<Int>,
    movies: List<DbMovie>,
    loadMore: () -> Unit,
    navToMovieDetail: (Int) -> Unit?
) {
    Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)) {

        TitleView(
            stringResourceId = R.string.recommendation,
            imgResourceId = R.drawable.ic_arrow_right
        )

        val listState = rememberLazyListState()
        LazyRow(
            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
            state = listState,
        ) {
            items(
                count = movies.distinct().size,
                key = { index ->
                    movies.distinct()[index].id
                }
            ) { index ->
                RecommendationViewDetail(movies.distinct()[index], navToMovieDetail)
            }
        }

        listState.OnLastItemReached {
            if (movies.isNotEmpty() && movies.distinct().size < totalMoviesRecommend.value) {
                loadMore.invoke()
            }
        }
    }
}

@Composable
fun RecommendationViewDetail(movie: DbMovie?, navToMovieDetail: (Int) -> Unit?) {
    Box(
        modifier = Modifier
            .size(width = 300.dp, height = 150.dp)
            .padding(end = 10.dp)
    ) {
        Card(
            modifier = Modifier,
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            LoadImage(
                imageUrl = movie?.backdropPath?.convertImageURL(),
                imageWith = 300,
                imageHeight = 150,
                onClick = {
                    navToMovieDetail.invoke(movie?.id?.toInt() ?: 0)
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewRecommendation() {
    val moviesRecommendation = remember { mutableStateListOf<DbMovie>() }
    val totalMoviesRecommend: MutableState<Int> = remember { mutableStateOf(0) }
    moviesRecommendation.addAll(listDbMovieFakeData)
    totalMoviesRecommend.value = 100
    RecommendationView(
        totalMoviesRecommend,
        moviesRecommendation,
        navToMovieDetail = {},
        loadMore = {}
    )
}
