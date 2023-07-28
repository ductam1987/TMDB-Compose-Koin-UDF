package com.tmdb.core.model.mapper

import com.tmdb.core.model.db.DbMovies
import com.tmdb.core.model.network.Movies

/**
 * Created by Tam Nguyen on 28/07/2023.
 */
class MoviesMapper : EntityMapper<DbMovies, Movies>  {

    override fun mapToEntity(domain: Movies): DbMovies {
        return DbMovies(
            totalPages = domain.total_pages.toLong(),
            totalResult = domain.total_results
        )
    }

    override fun mapFromEntity(entity: DbMovies): Movies {
        TODO("Not yet implemented")
    }
}