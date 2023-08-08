package com.tmdb.core.model.db

import io.objectbox.annotation.ConflictStrategy
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 27/07/2023.
 */

@Serializable
@Entity
data class DbMovie(
    @Id
    var id: Long = 0L,
    @Unique(onConflict = ConflictStrategy.REPLACE)
    var idMovie: Long = 0L,
    val posterPath: String?,
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean = false,
    val mediaType: String? = null,
    val adult: Boolean = false,
    val backdropPath: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val genreIds: List<String>? = null,
    val title: String? = null,
    val voteAverage: Double? = null,
    val overview: String? = null,
    val releaseDate: String? = null,
) {
    override fun toString(): String {
        return "DbMovie(id=$idMovie, posterPath=$posterPath, popularity=$popularity, voteCount=$voteCount, video=$video, mediaType=$mediaType, " +
            "adult=$adult, backdropPath=$backdropPath, originalLanguage=$originalLanguage, originalTitle=$originalTitle, genreIds=$genreIds, " +
            "title=$title, voteAverage=$voteAverage, overview=$overview, releaseDate=$releaseDate)"
    }
}

data class SubDbMovie(
    val totalResults: Int? = 0,
    val listDbMovies: List<DbMovie>? = emptyList()
)
