package com.tmdb.core.repos

import android.content.Context
import com.tmdb.core.model.db.DbMovie
import com.tmdb.core.model.db.DbMovieDetail
import com.tmdb.core.model.db.DbMovieDetail_
import com.tmdb.core.model.db.DbMovies
import com.tmdb.core.model.db.MyObjectBox
import com.tmdb.core.network.config.RecommendConfigDb
import io.objectbox.BoxStore
import io.objectbox.android.Admin
import io.objectbox.android.BuildConfig
import io.objectbox.exception.DbSchemaException

/**
 * Created by Tam Nguyen on 27/07/2023.
 */
class LocalDbRepositoryImpl : LocalDbRepository {

    private lateinit var boxStore: BoxStore

    private val movieBox get() = boxStore.boxFor(DbMovie::class.java)
    private val moviesBox get() = boxStore.boxFor(DbMovies::class.java)
    private val movieDetail get() = boxStore.boxFor(DbMovieDetail::class.java)

    override fun init(context: Context) {
        if (!::boxStore.isInitialized) {
            boxStore = try {
                MyObjectBox.builder().name("TMDB_ObjectBox").androidContext(context).build()
            } catch (e: DbSchemaException) {
                e.printStackTrace()
                BoxStore.deleteAllFiles(context, "TMDB_ObjectBox")
                MyObjectBox.builder().androidContext(context).build()
            }
            if (BuildConfig.DEBUG) {
                val admin = Admin(boxStore)
                admin.notificationId = 1
                admin.start(context)
            }
        }
    }

    override fun getBox(): BoxStore = boxStore

    override fun getListMovie(recommendConfigDb: RecommendConfigDb): List<DbMovie> {
        return movieBox.query().build().find(recommendConfigDb.offset, recommendConfigDb.limit)
    }

    override fun getMovies(): DbMovies? = moviesBox.query().build().findFirst()

    override fun getMovieDetail(movieId: Long): DbMovieDetail? = movieDetail.query(DbMovieDetail_.id.equal(movieId)).build().findFirst()

    override suspend fun saveListMovie(listDbMovie: List<DbMovie>) {
        val listDbMovieDistinct = listDbMovie.filter { movieNetwork ->
            movieBox.all.none { movieDb -> movieDb.idMovie == movieNetwork.idMovie }
        }
        movieBox.put(listDbMovieDistinct)
    }

    override suspend fun saveMovies(dbMovies: DbMovies) {
        moviesBox.put(dbMovies)
    }

    override suspend fun saveMovieDetail(dbMovieDetail: DbMovieDetail) {
        movieDetail.put(dbMovieDetail)
    }
}
