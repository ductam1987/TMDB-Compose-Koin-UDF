package com.tmdb.core.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 18/07/2023.
 */

@Serializable
data class VideoDetails(
    @SerialName(value = "id") val id: String,
    @SerialName(value = "iso_639_1") val iso_639_1: String,
    @SerialName(value = "iso_3166_1") val iso_3166_1: String,
    @SerialName(value = "key") val key: String?,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "site") val site: String,
    @SerialName(value = "type") val type: String
) {
    override fun toString(): String {
        return "VideoDetails(id='$id', iso_639_1='$iso_639_1', iso_3166_1='$iso_3166_1', " +
            "key=$key, name='$name', site='$site', type='$type')"
    }
}
