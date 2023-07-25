package com.tmdb.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 18/07/2023.
 */

@Serializable
data class Crew(
    @SerialName(value = "credit_id") val credit_id: String,
    @SerialName(value = "department") val department: String,
    @SerialName(value = "gender") val gender: Int,
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "job") val job: String,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "profile_path") val profile_path: String?
) {
    override fun toString(): String {
        return "Crew(credit_id='$credit_id', department='$department', " +
            "gender=$gender, id=$id, job='$job', name='$name', profile_path=$profile_path)"
    }
}
