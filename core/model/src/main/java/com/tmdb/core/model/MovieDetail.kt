package com.tmdb.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 18/07/2023.
 */

@Serializable
data class MovieDetail(
    @SerialName(value = "adult") val adult: Boolean = false,
    @SerialName(value = "backdrop_path") val backdrop_path: String?,
    @SerialName(value = "budget") val budget: Int,
    @SerialName(value = "genres") val genres: ArrayList<Genre>? = arrayListOf(),
    @SerialName(value = "homepage") val homepage: String?,
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "imdb_id") val imdb_id: String?,
    @SerialName(value = "original_language") val original_language: String?,
    @SerialName(value = "original_title") val original_title: String?,
    @SerialName(value = "overview") val overview: String?,
    @SerialName(value = "popularity") val popularity: Double = 0.0,
    @SerialName(value = "poster_path") val poster_path: String?,
    @SerialName(value = "release_date") val release_date: String?,
    @SerialName(value = "revenue") val revenue: Int,
    @SerialName(value = "runtime") val runtime: Int,
    @SerialName(value = "spoken_languages") val spoken_languages: ArrayList<SpokenLanguages> = arrayListOf(),
    @SerialName(value = "status") val status: String?,
    @SerialName(value = "tagline") val tagline: String?,
    @SerialName(value = "title") val title: String?,
    @SerialName(value = "video") val video: Boolean = false,
    @SerialName(value = "vote_average") val vote_average: Double,
    @SerialName(value = "vote_count") val vote_count: Int,
    @SerialName(value = "production_countries") val production_countries: ArrayList<ProductCountries>? = arrayListOf()
) {
    override fun toString(): String {
        return "MovieDetail(adult=$adult, backdrop_path=$backdrop_path, budget=$budget, genres=$genres, " +
            "homepage=$homepage, id=$id, imdb_id=$imdb_id, original_language=$original_language, " +
            "original_title=$original_title, overview=$overview, popularity=$popularity, poster_path=$poster_path, " +
            "release_date=$release_date, revenue=$revenue, runtime=$runtime, spoken_languages=$spoken_languages, " +
            "status=$status, tagline=$tagline, title=$title, video=$video, vote_average=$vote_average, vote_count=$vote_count, " +
            "production_countries=$production_countries)"
    }
}
