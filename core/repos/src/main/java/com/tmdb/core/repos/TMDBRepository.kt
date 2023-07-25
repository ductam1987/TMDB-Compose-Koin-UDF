package com.tmdb.core.repos

import com.tmdb.core.model.Categories
import com.tmdb.core.model.Movies

/**
 * Created by Tam Nguyen on 21/07/2023.
 */

interface TMDBRepository {
    suspend fun getMoviesRecommendations(movieId: Int, apiKey: String?, page: Int?): Movies?

    suspend fun getGender(apiKey: String?): Categories?

    suspend fun getMoviesPopular(apiKey: String?, page: Int?): Movies?

    suspend fun getMoviesTopRated(apiKey: String?, page: Int?): Movies?

    suspend fun getMoviesUpcoming(apiKey: String?, page: Int?): Movies?
}
