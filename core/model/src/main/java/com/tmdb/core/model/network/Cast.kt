package com.tmdb.core.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 18/07/2023.
 */

@Serializable
data class Cast(
    @SerialName(value = "cast_id") val cast_id: Int,
    @SerialName(value = "character") val character: String,
    @SerialName(value = "credit_id") val credit_id: String,
    @SerialName(value = "gender") val gender: Int,
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "order") val order: Int,
    @SerialName(value = "profile_path") val profile_path: String?
) {
    override fun toString(): String {
        return "Cast(cast_id=$cast_id, character='$character', credit_id='$credit_id', " +
            "gender=$gender, id=$id, name='$name', order=$order, profile_path=$profile_path)"
    }
}
