package com.tmdb.core.network

import com.skydoves.sandwich.ApiResponse
import com.tmdb.core.model.network.Categories
import com.tmdb.core.model.network.Credits
import com.tmdb.core.model.network.MovieDetail
import com.tmdb.core.model.network.Movies
import com.tmdb.core.model.network.Reviews
import com.tmdb.core.model.network.Videos
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Tam Nguyen on 21/07/2023.
 */

interface RestTMDBService {

    @GET("/3/genre/movie/list")
    suspend fun getGenres(@Query(value = "api_key") api_key: String?): ApiResponse<Categories>

    @GET("/3/movie/{movie_id}/recommendations")
    suspend fun getMoviesRecommendations(
        @Path("movie_id") movie_id: Int,
        @Query(value = "api_key") api_key: String?,
        @Query(value = "page") page: Int?
    ): ApiResponse<Movies>

    @GET("/3/movie/popular")
    suspend fun getMoviesPopular(
        @Query(value = "api_key") api_key: String?,
        @Query(value = "page") page: Int?
    ): ApiResponse<Movies>

    @GET("/3/movie/top_rated")
    suspend fun getMoviesTopRated(
        @Query(value = "api_key") api_key: String?,
        @Query(value = "page") page: Int?
    ): ApiResponse<Movies>

    @GET("/3/movie/upcoming")
    suspend fun getMoviesUpcoming(
        @Query(value = "api_key") api_key: String?,
        @Query(value = "page") page: Int?
    ): ApiResponse<Movies>

    @GET("/3/movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movie_id: Int,
        @Query(value = "api_key") api_key: String?
    ): ApiResponse<MovieDetail>

    @GET("/3/movie/{movie_id}/credits")
    suspend fun getCredits(
        @Path("movie_id") movie_id: Int,
        @Query(value = "api_key") api_key: String
    ): ApiResponse<Credits>

    @GET("/3/movie/{movie_id}/videos")
    suspend fun getVideos(
        @Path("movie_id") movie_id: Int,
        @Query(value = "api_key") api_key: String
    ): ApiResponse<Videos>

    @GET("/3/movie/{movie_id}/reviews")
    suspend fun getReviews(
        @Path("movie_id") movie_id: Int,
        @Query(value = "api_key") api_key: String,
        @Query(value = "page") page: Int
    ): ApiResponse<Reviews>
}
