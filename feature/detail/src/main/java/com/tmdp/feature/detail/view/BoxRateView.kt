package com.tmdp.feature.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import theme.colorNeutralLight

/**
 * Created by Tam Nguyen on 23/07/2023.
 */

@Composable
fun BoxRateView() {
    var rating: Float by remember { mutableStateOf(0f) }

    ConstraintLayout(modifier = Modifier.background(color = Color.White).padding(top = 20.dp)) {

        val (tvRateTitle, ratingBar, tvRatingNumber, tvWriteComment) = createRefs()
        Box(
            modifier = Modifier
                .constrainAs(tvRateTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .height(45.dp)
                .fillMaxWidth()
                .background(color = colorNeutralLight),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Your Rate",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        RatingBar(
            modifier = Modifier.constrainAs(ratingBar) {
                top.linkTo(tvRateTitle.bottom, 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            size = 40.dp,
            value = rating,
            style = RatingBarStyle.Fill(),
            onValueChange = {
                rating = it
            },
            onRatingChanged = {
            }
        )

        Text(
            text = "0.0",
            modifier = Modifier.constrainAs(tvRatingNumber) {
                top.linkTo(ratingBar.bottom, 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "WRITE A COMMENT", fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .constrainAs(tvWriteComment) {
                    top.linkTo(tvRatingNumber.bottom, 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .drawBehind {
                    drawRoundRect(
                        Color(0xFF007bd9),
                        cornerRadius = CornerRadius(6.dp.toPx())
                    )
                }
                .padding(start = 6.dp, top = 4.dp, end = 6.dp, bottom = 4.dp)
        )
    }
}

@Preview
@Composable
fun PreviewBoxRate() {
    BoxRateView()
}
