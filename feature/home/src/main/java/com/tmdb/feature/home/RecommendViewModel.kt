package com.tmdb.feature.home

import Constants
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmdb.core.model.db.SubDbMovie
import com.tmdb.core.model.mapper.MoviesMapper
import com.tmdb.core.model.mapper.RecommendationMapper
import com.tmdb.core.model.network.Categories
import com.tmdb.core.model.network.Movies
import com.tmdb.core.network.CoroutineDispatchers
import com.tmdb.core.network.config.RecommendConfigNetwork
import com.tmdb.core.repos.LocalDbRepository
import com.tmdb.core.repos.TMDBRepository
import com.tmdb.core.ui.base.StateModel
import com.tmdb.core.ui.module.RecommendationModule
import com.tmdb.core.ui.network.ResultData
import kotlinx.coroutines.launch

/**
 * Created by Tam Nguyen on 17/07/2023.
 */
class RecommendViewModel(
    private val tmDBRepositoryImpl: TMDBRepository,
    private val coroutineDispatchersImpl: CoroutineDispatchers,
    private val localDbRepositoryImpl: LocalDbRepository,
    private val recommendationMapper: RecommendationMapper,
    private val moviesMapper: MoviesMapper,
) : ViewModel() {

    val genre = StateModel<Categories?>(null)

    fun getTMDBRecommend(paging: Int, callbackMovie: (SubDbMovie?) -> Unit) {
        val recommendConfig = RecommendConfigNetwork(
            movieId = Constants.MOVIE_ID,
            apiKey = Constants.API_KEY,
            page = paging
        )
        viewModelScope.launch {
            RecommendationModule.provideRecommendationModule(
                recommendationMapper = recommendationMapper,
                moviesMapper = moviesMapper,
                coroutineDispatchers = coroutineDispatchersImpl,
                localDbRepository = localDbRepositoryImpl,
                tmdbRepository = tmDBRepositoryImpl,
                recommendConfig = recommendConfig
            ).collect { state ->
                when (state) {
                    is ResultData.SuccessLocal -> {
                        callbackMovie.invoke(state.data)
                    }

                    is ResultData.SuccessMerged -> {
                        callbackMovie.invoke(state.data)
                    }

                    is ResultData.Error -> {
                    }

                    is ResultData.Loading -> {
                    }
                }
            }
        }
    }

    fun getTMDBGender() {
        viewModelScope.launch(coroutineDispatchersImpl.io) {
            genre.updateEvent(tmDBRepositoryImpl.getGender(Constants.API_KEY))
        }
    }

    fun getTMDBPopular(paging: Int, callbackMovie: (Movies?) -> Unit) {
        viewModelScope.launch {
            tmDBRepositoryImpl.getMoviesPopular(apiKey = Constants.API_KEY, page = paging).let {
                callbackMovie(it)
            }
        }
    }

    fun getTMDBTopRated(paging: Int, callbackMovie: (Movies?) -> Unit) {
        viewModelScope.launch {
            tmDBRepositoryImpl.getMoviesTopRated(apiKey = Constants.API_KEY, page = paging).let {
                callbackMovie(it)
            }
        }
    }

    fun getTMDBUpcoming(paging: Int, callbackMovie: (Movies?) -> Unit) {
        viewModelScope.launch {
            tmDBRepositoryImpl.getMoviesUpcoming(apiKey = Constants.API_KEY, page = paging).let {
                callbackMovie(it)
            }
        }
    }
}
