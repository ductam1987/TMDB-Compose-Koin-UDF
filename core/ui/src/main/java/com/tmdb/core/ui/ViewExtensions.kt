package com.tmdb.core.ui

/**
 * Created by Tam Nguyen on 16/07/2023.
 */
fun String.convertImageURL(): String {
    return "https://image.tmdb.org/t/p/w500".plus(this)
}

fun String.convertYoutubeThumbnails(): String {
    return "https://img.youtube.com/vi/".plus(this).plus("/0.jpg")
}

fun String.convertYoutubeUrl(): String {
    return "https://www.youtube.com/watch?v=".plus(this)
}

fun String.convertAvatarURL(): String {
    return if (this.first().toString() == "/") {
        val stringBuilder = StringBuilder(this)
        stringBuilder.deleteCharAt(0).toString()
    } else {
        this
    }
}
