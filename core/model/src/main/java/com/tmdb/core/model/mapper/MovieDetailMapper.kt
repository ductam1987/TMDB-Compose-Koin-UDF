package com.tmdb.core.model.mapper

import com.tmdb.core.model.db.DbMovieDetail
import com.tmdb.core.model.network.MovieDetail
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Created by Tam Nguyen on 29/07/2023.
 */
class MovieDetailMapper(
    private val jsonSerializer: Json,
) : EntityMapper<DbMovieDetail, MovieDetail> {
    override fun mapFromEntity(entity: DbMovieDetail): MovieDetail {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domain: MovieDetail): DbMovieDetail {
        return DbMovieDetail(
            id = domain.id.toLong(),
            adult = domain.adult,
            backdropPath = domain.backdrop_path,
            budget = domain.budget,
            genres = jsonSerializer.encodeToString(domain.genres),
            homepage = domain.homepage,
            imdbId = domain.imdb_id,
            originalLanguage = domain.original_language,
            originalTitle = domain.original_title,
            overview = domain.overview,
            popularity = domain.popularity,
            posterPath = domain.poster_path,
            releaseDate = domain.release_date,
            revenue = domain.revenue,
            runtime = domain.runtime,
            spokenLanguages = jsonSerializer.encodeToString(domain.spoken_languages), // domain.spoken_languages,
            status = domain.status,
            tagline = domain.tagline,
            title = domain.title,
            video = domain.video,
            voteAverage = domain.vote_average,
            voteCount = domain.vote_count,
            productionCountries = jsonSerializer.encodeToString(domain.production_countries) // domain.production_countries
        )
    }
}
