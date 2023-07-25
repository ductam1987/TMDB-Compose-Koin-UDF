package com.tmdb.core.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * Created by Tam Nguyen on 16/07/2023.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoadImage(
    modifier: Modifier? = Modifier,
    imageWith: Int?,
    imageHeight: Int,
    imageUrl: String? = null,
    contentScale: ContentScale? = null,
    cornerShape: Int? = null,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    onLoadError: (() -> Unit)? = null,
    paddingValues: Dp = 0.dp,
    isShowPlaceholder: Boolean = true,
) {
    AsyncImage(
        model = imageUrl,
        placeholder = if (isShowPlaceholder) painterResource(R.drawable.img_sample) else null,
        contentScale = contentScale ?: ContentScale.FillBounds,
        contentDescription = "Image",
        modifier = Modifier
            .height(imageHeight.dp)
            .clip(cornerShape.shapesRounded)
            .combinedClickable(
                onClick = onClick ?: {},
                onLongClick = onLongClick,
            )
            .padding(horizontal = paddingValues)
            .then(
                if (imageWith == null) {
                    Modifier.fillMaxWidth()
                } else {
                    Modifier.width(imageWith.dp)
                }
            ),
        onError = {
            onLoadError?.let { error ->
                error()
            }
        },
    )
}
