package com.tmdb.core.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 18/07/2023.
 */

@Serializable
data class Categories(
    @SerialName(value = "genres") val genres: List<Genre>?
) {
    override fun toString(): String {
        return "Categories(genres=$genres)"
    }
}
