package com.tmdb.core.model.db

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 29/07/2023.
 */

@Serializable
@Entity
data class DbMovieDetail(
    @Id(assignable = true)
    var id: Long = 0L,
    val adult: Boolean = false,
    val backdropPath: String?,
    val budget: Int,
    val genres: String, // ArrayList<Genre>? = arrayListOf(),
    val homepage: String?,
    val imdbId: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double = 0.0,
    val posterPath: String?,
    val releaseDate: String?,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: String?, // ArrayList<SpokenLanguages> = arrayListOf(),
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean = false,
    val voteAverage: Double,
    val voteCount: Int,
    val productionCountries: String? // ArrayList<ProductCountries>? = arrayListOf()
) {
    override fun toString(): String {
        return "DbMovieDetail(id=$id, adult=$adult, backdropPath=$backdropPath, budget=$budget, genres=$genres, " +
            "homepage=$homepage, imdbId=$imdbId, originalLanguage=$originalLanguage, originalTitle=$originalTitle, " +
            "overview=$overview, popularity=$popularity, posterPath=$posterPath, releaseDate=$releaseDate, " +
            "revenue=$revenue, runtime=$runtime, spokenLanguages=$spokenLanguages, status=$status, tagline=$tagline, " +
            "title=$title, video=$video, voteAverage=$voteAverage, voteCount=$voteCount, productionCountries=$productionCountries)"
    }
}
