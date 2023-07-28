package com.tmdb.core.repos

import com.skydoves.sandwich.getOrElse
import com.tmdb.core.model.network.Credits
import com.tmdb.core.model.network.MovieDetail
import com.tmdb.core.model.network.Reviews
import com.tmdb.core.model.network.Videos
import com.tmdb.core.network.RestTMDBService

/**
 * Created by Tam Nguyen on 23/07/2023.
 */
class MovieDetailRepositoryImpl(private val restTMDBService: RestTMDBService) : MovieDetailRepository {
    override suspend fun getMovieDetail(apiKey: String?, movieId: Int): MovieDetail? {
        return restTMDBService.getMovieDetails(movie_id = movieId, api_key = apiKey).getOrElse {
            null
        }
    }

    override suspend fun getMovieCast(apiKey: String, movieId: Int): Credits? {
        return restTMDBService.getCredits(movie_id = movieId, api_key = apiKey).getOrElse(null)
    }

    override suspend fun getMovieVideo(apiKey: String, movieId: Int): Videos? {
        return restTMDBService.getVideos(movie_id = movieId, api_key = apiKey).getOrElse(null)
    }

    override suspend fun getMovieReview(apiKey: String, movieId: Int): Reviews? {
        return restTMDBService.getReviews(movie_id = movieId, api_key = apiKey, page = 1).getOrElse(null)
    }
}
