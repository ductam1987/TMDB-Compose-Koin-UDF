package com.tmdb.core.repos

import android.content.Context
import com.tmdb.core.model.db.DbMovie
import com.tmdb.core.model.db.DbMovies
import com.tmdb.core.model.db.MyObjectBox
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
    override fun getListMovie(): List<DbMovie> {
        return movieBox.query().build().find()
    }

    override fun getMovies(): DbMovies? = moviesBox.query().build().findFirst()

    override suspend fun saveListMovie(listDbMovie: List<DbMovie>) = movieBox.put(listDbMovie)
    override suspend fun saveMovies(dbMovies: DbMovies) {
        moviesBox.put(dbMovies)
    }
}
