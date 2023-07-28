package com.tmdb.core.model.db

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 28/07/2023.
 */

@Serializable
@Entity
data class DbMovies(
    @Id(assignable = true)
    var totalPages: Long = 0L,
    val totalResult: Int?
) {
    override fun toString(): String {
        return "DbMovies(totalPages=$totalPages, totalResult=$totalResult)"
    }
}
