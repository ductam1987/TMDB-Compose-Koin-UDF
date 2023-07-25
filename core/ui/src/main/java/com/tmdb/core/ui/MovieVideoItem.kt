package com.tmdb.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import theme.colorPorcelain

/**
 * Created by Tam Nguyen on 24/07/2023.
 */

@Composable
fun MovieVideoItem(keyYoutube: String, videoClick: (String) -> Unit?) {
    Box(
        modifier = Modifier.size(width = 200.dp, height = 113.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.padding(end = 10.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorPorcelain
            )
        ) {
            LoadImage(
                imageWith = 200,
                imageHeight = 113,
                imageUrl = keyYoutube.convertYoutubeThumbnails(),
                onClick = { videoClick.invoke(keyYoutube) }
            )
        }

        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = R.drawable.icons_circled_play),
            contentDescription = "Button back"
        )
    }
}

@Preview
@Composable
fun PreviewMovieVideoItem() {
    MovieVideoItem(keyYoutube = "sadffds", videoClick = {})
}
