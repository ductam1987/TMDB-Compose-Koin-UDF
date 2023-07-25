package com.tmdb.core.repos

import com.skydoves.sandwich.getOrElse
import com.tmdb.core.model.Categories
import com.tmdb.core.model.Movies
import com.tmdb.core.network.RestTMDBService

/**
 * Created by Tam Nguyen on 21/07/2023.
 */
class TMDBRepositoryImpl(private val restTMDBService: RestTMDBService) : TMDBRepository {

    override suspend fun getMoviesRecommendations(movieId: Int, apiKey: String?, page: Int?): Movies? {
        return restTMDBService.getMoviesRecommendations(movie_id = movieId, api_key = apiKey, page = page).getOrElse {
            null
        }
    }

    override suspend fun getGender(apiKey: String?): Categories? {
        return restTMDBService.getGenres(api_key = apiKey).getOrElse {
            null
        }
    }

    override suspend fun getMoviesPopular(apiKey: String?, page: Int?): Movies? {
        return restTMDBService.getMoviesPopular(api_key = apiKey, page = page).getOrElse {
            null
        }

        // restTMDBService.getMoviesPopular(api_key = apiKey, page = page).suspendMapSuccess {
        //     Log.d("TAG", " suspendMapSuccess::: " + this)
        // }.suspendOnError {
        //     Log.d("TAG", " suspendOnError::: " + this.errorBody)
        // }.suspendOnFailure {
        //     Log.d("TAG", " suspendOnFailure::: $this")
        // }
        // return null
    }

    override suspend fun getMoviesTopRated(apiKey: String?, page: Int?): Movies? {
        return restTMDBService.getMoviesTopRated(api_key = apiKey, page = page).getOrElse {
            null
        }
    }

    override suspend fun getMoviesUpcoming(apiKey: String?, page: Int?): Movies? {
        return restTMDBService.getMoviesUpcoming(api_key = apiKey, page = page).getOrElse {
            null
        }
    }
}
