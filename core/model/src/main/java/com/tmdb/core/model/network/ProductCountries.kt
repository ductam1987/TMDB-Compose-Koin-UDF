package com.tmdb.core.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 18/07/2023.
 */

@Serializable
data class ProductCountries(
    @SerialName(value = "iso_3166_1") val iso_3166_1: String?,
    @SerialName(value = "name") val name: String?
) {
    override fun toString(): String {
        return "ProductCountries(iso_3166_1=$iso_3166_1, name=$name)"
    }
}
