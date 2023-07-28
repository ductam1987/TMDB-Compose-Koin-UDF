package com.tmdb.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.tmdb.core.model.network.ReviewDetails
import com.tmdb.core.model.fakeData.reviewDetailsFakeData

/**
 * Created by Tam Nguyen on 24/07/2023.
 */

@Composable
fun MovieReviewItem(reviewDetail: ReviewDetails) {

    ConstraintLayout(
        modifier = Modifier
            .background(color = Color.White)
            .padding(end = 10.dp)
            .fillMaxWidth()

    ) {
        val (imgAvatar, tvName, tvDesc, divider, tvReleaseDate) = createRefs()

        Box(
            modifier = Modifier
                .constrainAs(imgAvatar) {
                    top.linkTo(parent.top, 10.dp)
                    start.linkTo(parent.start, 5.dp)
                }
        ) {
            LoadImage(imageWith = 50, imageHeight = 50, imageUrl = reviewDetail.authorDetail.avatar_path?.convertAvatarURL())
        }

        Text(
            text = reviewDetail.author,
            modifier = Modifier.constrainAs(tvName) {
                top.linkTo(imgAvatar.top)
                start.linkTo(imgAvatar.end, 5.dp)
            },
            fontWeight = FontWeight.Bold
        )

        Text(
            text = reviewDetail.content,
            modifier = Modifier
                .constrainAs(tvDesc) {
                    top.linkTo(tvName.bottom, 5.dp)
                    start.linkTo(imgAvatar.end)
                    end.linkTo(parent.end)
                }
                .wrapContentSize()
                .padding(start = 35.dp, end = 20.dp),
            maxLines = 5,
            fontSize = 12.sp,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = reviewDetail.updatedAt,
            modifier = Modifier.constrainAs(tvReleaseDate) {
                top.linkTo(tvDesc.bottom, 5.dp)
                start.linkTo(imgAvatar.end, 10.dp)
            },
            fontSize = 12.sp,
            overflow = TextOverflow.Ellipsis
        )

        Divider(
            color = Color.Gray,
            modifier = Modifier
                .constrainAs(divider) {
                    top.linkTo(tvReleaseDate.bottom, 5.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .height(1.dp),
            thickness = 1.dp,
        )
    }
}

@Preview
@Composable
fun PreviewMovieReviewItem() {
    MovieReviewItem(reviewDetail = reviewDetailsFakeData)
}
