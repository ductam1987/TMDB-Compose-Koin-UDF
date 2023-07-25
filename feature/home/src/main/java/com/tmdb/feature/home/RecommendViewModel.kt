package com.tmdb.feature.home

import Constants
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmdb.core.model.Categories
import com.tmdb.core.model.Movies
import com.tmdb.core.network.CoroutineDispatchers
import com.tmdb.core.repos.TMDBRepository
import com.tmdb.core.ui.base.StateModel
import kotlinx.coroutines.launch

/**
 * Created by Tam Nguyen on 17/07/2023.
 */
class RecommendViewModel(
    private val tmDBRepository: TMDBRepository,
    private val coroutineDispatchersIml: CoroutineDispatchers,
) : ViewModel() {

    val genre = StateModel<Categories?>(null)

    fun getTMDBRecommend(paging: Int, callbackMovie: (Movies?) -> Unit) {
        viewModelScope.launch {
            tmDBRepository.getMoviesRecommendations(movieId = Constants.MOVIE_ID, apiKey = Constants.API_KEY, page = paging).let {
                callbackMovie(it)
            }
        }
    }

    fun getTMDBGender() {
        viewModelScope.launch(coroutineDispatchersIml.io) {
            genre.updateEvent(tmDBRepository.getGender(Constants.API_KEY))
        }
    }

    fun getTMDBPopular(paging: Int, callbackMovie: (Movies?) -> Unit) {
        viewModelScope.launch {
            tmDBRepository.getMoviesPopular(apiKey = Constants.API_KEY, page = paging).let {
                callbackMovie(it)
            }
        }
    }

    fun getTMDBTopRated(paging: Int, callbackMovie: (Movies?) -> Unit) {
        viewModelScope.launch {
            tmDBRepository.getMoviesTopRated(apiKey = Constants.API_KEY, page = paging).let {
                callbackMovie(it)
            }
        }
    }

    fun getTMDBUpcoming(paging: Int, callbackMovie: (Movies?) -> Unit) {
        viewModelScope.launch {
            tmDBRepository.getMoviesUpcoming(apiKey = Constants.API_KEY, page = paging).let {
                callbackMovie(it)
            }
        }
    }
}
