package com.tmdp.feature.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tmdb.core.model.network.VideoDetails
import com.tmdb.core.ui.MovieVideoItem
import theme.colorNeutralLight

/**
 * Created by Tam Nguyen on 24/07/2023.
 */

@Composable
fun MovieVideoView(listVideos: List<VideoDetails>, videoClick: (String) -> Unit?) {
    Column(modifier = Modifier.padding(top = 20.dp)) {

        Box(
            modifier = Modifier
                .height(45.dp)
                .fillMaxWidth()
                .background(color = colorNeutralLight),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Video",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyRow(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
        ) {
            items(
                count = listVideos.size,
                key = { index ->
                    listVideos[index].id
                }
            ) { index ->
                listVideos[index].key?.let { key ->
                    MovieVideoItem(keyYoutube = key, videoClick = videoClick)
                }
            }
        }
    }
}
