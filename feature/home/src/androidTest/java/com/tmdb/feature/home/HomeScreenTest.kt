package com.tmdb.feature.home

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.tmdb.core.testing.fakeData.listDbMovieFakeData
import org.junit.Rule
import org.junit.Test

/**
 * Created by Tam Nguyen on 23/08/2023.
 */

class HomeScreenTest {

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun homeScreenTestDetail() {
        composeTestRule.setContent {
            Box(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxSize()
            ) {
                listDbMovieFakeData
                // HomeScreenDetail(
                //     totalMoviesRecommend = totalMoviesRecommend,
                //     moviesRecommendation = listDbMovieFakeData,
                //     genreList = listGenreFakeData,
                //     totalMoviesPopular = totalMoviesRecommend,
                //     moviesPopular = listMovieFakeData,
                //     totalMoviesTopRated = totalMoviesRecommend,
                //     moviesTopRated = listMovieFakeData,
                //     totalMoviesUpcoming = totalMoviesRecommend,
                //     moviesUpcoming = listMovieFakeData,
                //     loadMoreRecommendation = { /*TODO*/ },
                //     loadMorePopular = { /*TODO*/ },
                //     loadMoreTopRated = { /*TODO*/ },
                //     loadMoreUpcoming = { /*TODO*/ },
                //     navToMovieDetail = {}
                // )
            }
        }
    }
}
