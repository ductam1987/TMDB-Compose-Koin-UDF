package com.tmdb.feature.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tmdb.core.model.network.Genre
import com.tmdb.core.model.fakeData.genreFakeData1
import com.tmdb.core.ui.TitleView
import com.tmdb.feature.recommend.R
import theme.blueMain

/**
 * Created by Tam Nguyen on 17/07/2023.
 */

@Composable
fun CategoryView(listGenre: List<Genre>) {
    Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)) {

        TitleView(stringResourceId = R.string.category, imgResourceId = R.drawable.ic_arrow_right)

        LazyRow(
            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
        ) {
            items(
                count = listGenre.size,
                key = { index ->
                    listGenre[index].id
                }
            ) { index ->
                CategoryViewDetail(listGenre[index])
            }
        }
    }
}

@Composable
fun CategoryViewDetail(genre: Genre) {
    Card(
        modifier = Modifier.padding(end = 10.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = blueMain
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .height(75.dp)
                .width(150.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = genre.name ?: "",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun PreviewCategoryViewDetail() {
    CategoryViewDetail(genre = genreFakeData1)
}
