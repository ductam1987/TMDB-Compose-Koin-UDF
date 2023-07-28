package com.tmdb.core.repos

import com.skydoves.sandwich.ApiResponse
import com.tmdb.core.model.network.Categories
import com.tmdb.core.model.network.Movies
import com.tmdb.core.network.config.RecommendConfig

/**
 * Created by Tam Nguyen on 21/07/2023.
 */

interface TMDBRepository {
    suspend fun getMoviesRecommendations(recommendConfig: RecommendConfig): ApiResponse<Movies?>

    suspend fun getGender(apiKey: String?): Categories?

    suspend fun getMoviesPopular(apiKey: String?, page: Int?): Movies?

    suspend fun getMoviesTopRated(apiKey: String?, page: Int?): Movies?

    suspend fun getMoviesUpcoming(apiKey: String?, page: Int?): Movies?
}
