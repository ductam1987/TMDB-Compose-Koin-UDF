package com.tmdb.core.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 18/07/2023.
 */

@Serializable
data class Videos(
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "results") val results: ArrayList<VideoDetails>?
) {
    override fun toString(): String {
        return "Videos(id=$id, results=$results)"
    }
}
