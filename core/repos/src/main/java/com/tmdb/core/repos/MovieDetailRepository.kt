package com.tmdb.core.repos

import com.tmdb.core.model.Credits
import com.tmdb.core.model.MovieDetail
import com.tmdb.core.model.Reviews
import com.tmdb.core.model.Videos

/**
 * Created by Tam Nguyen on 23/07/2023.
 */
interface MovieDetailRepository {

    suspend fun getMovieDetail(apiKey: String?, movieId: Int): MovieDetail?

    suspend fun getMovieCast(apiKey: String, movieId: Int): Credits?

    suspend fun getMovieVideo(apiKey: String, movieId: Int): Videos?

    suspend fun getMovieReview(apiKey: String, movieId: Int): Reviews?
}
