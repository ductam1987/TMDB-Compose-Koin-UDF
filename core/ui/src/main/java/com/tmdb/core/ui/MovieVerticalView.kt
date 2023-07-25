package com.tmdb.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.colorShuttleGray

/**
 * Created by Tam Nguyen on 19/07/2023.
 */

@Composable
fun MovieVerticalView(movieImg: String?, movieName: String?, movieId: Int, navToMovieDetail: (Int) -> Unit?) {
    Card(
        modifier = Modifier
            .padding(end = 10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .height(210.dp)
                .width(120.dp),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(5.dp)

        ) {
            LoadImage(
                imageUrl = movieImg?.convertImageURL(), imageHeight = 180, imageWith = 120,
                onClick = {
                    navToMovieDetail.invoke(movieId)
                }
            )
            Text(
                modifier = Modifier.padding(start = 2.dp, end = 2.dp),
                text = movieName ?: "",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = colorShuttleGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun PreviewMovieVerticalView() {
    MovieVerticalView(movieImg = null, movieName = "movieName ", movieId = 1) {}
}
