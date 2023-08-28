package com.tmdb.core.ui.dataTest

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.tmdb.core.model.network.Genre

/**
 * Created by Tam Nguyen on 29/08/2023.
 */
class GenrePreviewParameterProvider : PreviewParameterProvider<DbGenreFakeDataPreviewUI> {
    override val values: Sequence<DbGenreFakeDataPreviewUI> = sequenceOf(DbGenreFakeDataPreviewUI)
}

object DbGenreFakeDataPreviewUI {
    val listGenreFakeDataPreviewUI = listOf(
        Genre(id = 28, "Action"),
        Genre(id = 12, "Adventure"),
        Genre(id = 16, "Animation"),
        Genre(id = 35, "Comedy"),
        Genre(id = 80, "Crime"),
        Genre(id = 99, "Documentary")
    )
}
