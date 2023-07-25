package com.tmdb.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Tam Nguyen on 18/07/2023.
 */

@Serializable
data class Movie(
    @SerialName(value = "poster_path") val poster_path: String?,
    @SerialName(value = "popularity") val popularity: Double,
    @SerialName(value = "vote_count") val vote_count: Int,
    @SerialName(value = "video") val video: Boolean = false,
    @SerialName(value = "media_type") val media_type: String? = null,
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "adult") val adult: Boolean = false,
    @SerialName(value = "backdrop_path") val backdrop_path: String? = null,
    @SerialName(value = "original_language") val original_language: String,
    @SerialName(value = "original_title") val original_title: String,
    @SerialName(value = "genre_ids") val genre_ids: ArrayList<String> = arrayListOf(),
    @SerialName(value = "title") val title: String,
    @SerialName(value = "vote_average") val vote_average: Double,
    @SerialName(value = "overview") val overview: String,
    @SerialName(value = "release_date") val release_date: String
) {
    override fun toString(): String {
        return "Movie(poster_path=$poster_path, popularity=$popularity, vote_count=$vote_count, " +
            "video=$video, media_type='$media_type', id=$id, adult=$adult, backdrop_path='$backdrop_path', " +
            "original_language='$original_language', original_title='$original_title', genre_ids=$genre_ids, " +
            "title='$title', vote_average=$vote_average, overview='$overview', release_date='$release_date')"
    }
}
