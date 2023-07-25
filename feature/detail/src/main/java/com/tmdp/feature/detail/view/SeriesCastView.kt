package com.tmdp.feature.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.colorDustyGray

/**
 * Created by Tam Nguyen on 23/07/2023.
 */

@Composable
fun SeriesCastView() {
    Column {
        Box(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(color = colorDustyGray),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "YOUR RATE",
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        val listState = rememberLazyListState()
        LazyRow(
            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
            state = listState,
        ) {
            // items(
            //     count = movies.distinct().size,
            //     key = { index ->
            //         movies.distinct()[index].id
            //     }
            // ) { index ->
            //     RecommendationViewDetail(movies.distinct()[index])
            // }
        }
    }
}

@Preview
@Composable
fun PreviewSeriesCast() {
    SeriesCastView()
}
