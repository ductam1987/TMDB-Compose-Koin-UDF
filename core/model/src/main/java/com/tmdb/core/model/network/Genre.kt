package com.tmdb.core.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 18/07/2023.
 */

@Serializable
data class Genre(
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "name") val name: String? = null
) {
    override fun toString(): String {
        return "Genre(id=$id, name='$name')"
    }
}
