package com.tmdb.core.repos

import com.skydoves.sandwich.ApiResponse
import com.tmdb.core.model.network.Credits
import com.tmdb.core.model.network.MovieDetail
import com.tmdb.core.model.network.Reviews
import com.tmdb.core.model.network.Videos
import com.tmdb.core.network.config.MovieDetailConfig

/**
 * Created by Tam Nguyen on 23/07/2023.
 */
interface MovieDetailRepository {

    suspend fun getMovieDetail(movieDetailConfig: MovieDetailConfig): ApiResponse<MovieDetail?>

    suspend fun getMovieCast(apiKey: String, movieId: Int): Credits?

    suspend fun getMovieVideo(apiKey: String, movieId: Int): Videos?

    suspend fun getMovieReview(apiKey: String, movieId: Int): Reviews?
}
