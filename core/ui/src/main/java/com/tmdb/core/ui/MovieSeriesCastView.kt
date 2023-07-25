package com.tmdb.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.colorPorcelain
import theme.colorShuttleGray

/**
 * Created by Tam Nguyen on 23/07/2023.
 */

@Composable
fun MovieSeriesCastView(castImgUrl: String?, castName: String?) {
    Card(
        modifier = Modifier.padding(end = 10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorPorcelain
        )
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(3.dp)

        ) {
            LoadImage(
                imageUrl = castImgUrl?.convertImageURL(),
                imageHeight = 100,
                imageWith = 75
            )
            Text(
                modifier = Modifier
                    .padding(start = 2.dp, end = 2.dp)
                    .height(15.dp)
                    .widthIn(max = 75.dp),
                text = castName ?: "",
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                color = colorShuttleGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun PreviewMovieSeriesCastView() {
    MovieSeriesCastView(castImgUrl = null, castName = "castName")
}
