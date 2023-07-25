package com.tmdb.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 24/07/2023.
 */

@Serializable
data class AuthorDetail(
    @SerialName(value = "name") val name: String?,
    @SerialName(value = "username") val username: String?,
    @SerialName(value = "avatar_path") val avatar_path: String?,
) {
    override fun toString(): String {
        return "AuthorDetail(name=$name, username=$username, avatar_path=$avatar_path)"
    }
}
