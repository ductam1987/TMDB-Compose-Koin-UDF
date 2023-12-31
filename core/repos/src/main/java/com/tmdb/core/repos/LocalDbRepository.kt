package com.tmdb.core.repos

import android.content.Context
import com.tmdb.core.model.db.DbMovie
import com.tmdb.core.model.db.DbMovieDetail
import com.tmdb.core.model.db.DbMovies
import com.tmdb.core.network.config.RecommendConfigDb
import io.objectbox.BoxStore

/**
 * Created by Tam Nguyen on 27/07/2023.
 */
interface LocalDbRepository {

    fun init(context: Context)

    fun getBox(): BoxStore

    fun getListMovie(recommendConfigDb: RecommendConfigDb): List<DbMovie>

    fun getMovies(): DbMovies?

    fun getMovieDetail(movieId: Long): DbMovieDetail?

    suspend fun saveListMovie(listDbMovie: List<DbMovie>)

    suspend fun saveMovies(dbMovies: DbMovies)

    suspend fun saveMovieDetail(dbMovieDetail: DbMovieDetail)
}
