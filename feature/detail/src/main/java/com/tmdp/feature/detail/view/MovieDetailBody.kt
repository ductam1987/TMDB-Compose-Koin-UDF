package com.tmdp.feature.detail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import com.tmdb.core.model.db.DbMovieDetail
import com.tmdb.core.model.network.Genre
import com.tmdb.core.model.network.ProductCountries
import com.tmdb.core.ui.DevicePreviews
import com.tmdb.core.ui.LoadImage
import com.tmdb.core.ui.convertImageURL
import com.tmdb.core.ui.dataTest.MovieDetailFakeDataPreviewUI
import com.tmdb.core.ui.dataTest.MovieDetailPreviewParameterProvider
import com.tmdb.feature.detail.R
import kotlinx.serialization.json.Json

/**
 * Created by Tam Nguyen on 24/07/2023.
 */
@Composable
fun MovieDetailBody(movieDetail: DbMovieDetail, navBack: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        val (
            imgBack, imgMovieScreen, imgMovieThumb, tvRatedNumber, ratingbarMovie, tvMovieDate,
            tvCountry, tvGenre, tvMovieName, tvMovieDesc
        ) = createRefs()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .constrainAs(imgMovieScreen) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            LoadImage(imageWith = null, imageHeight = 250, imageUrl = movieDetail.backdropPath?.convertImageURL())
        }

        Image(
            modifier = Modifier
                .constrainAs(imgBack) {
                    top.linkTo(parent.top, 10.dp)
                    start.linkTo(parent.start, 20.dp)
                }
                .size(30.dp)
                .clickable {
                    navBack.invoke()
                },
            painter = painterResource(id = R.drawable.btn_back),
            contentDescription = "Button back"
        )

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(150.dp)
                .constrainAs(imgMovieThumb) {
                    top.linkTo(parent.top, 200.dp)
                    start.linkTo(parent.start, 15.dp)
                }
        ) {
            LoadImage(imageWith = 100, imageHeight = 150, imageUrl = movieDetail.posterPath?.convertImageURL())
        }

        val rated = (movieDetail.voteAverage * 5) / 10
        Text(
            text = rated.toString(),
            fontSize = 16.sp, maxLines = 1,
            modifier = Modifier
                .constrainAs(tvRatedNumber) {
                    top.linkTo(imgMovieScreen.bottom, 15.dp)
                    start.linkTo(imgMovieThumb.end, 10.dp)
                }
                .widthIn(max = 50.dp)
        )

        RatingBar(
            modifier = Modifier.constrainAs(ratingbarMovie) {
                top.linkTo(tvRatedNumber.top)
                start.linkTo(tvRatedNumber.end, 10.dp)
                bottom.linkTo(tvRatedNumber.bottom)
            },
            size = 20.dp,
            value = rated.toFloat(),
            style = RatingBarStyle.Fill(),
            onValueChange = {
            },
            onRatingChanged = {
            }
        )

        Text(
            text = movieDetail.releaseDate.toString(), fontSize = 16.sp,
            modifier = Modifier.constrainAs(tvMovieDate) {
                top.linkTo(tvRatedNumber.bottom, 10.dp)
                start.linkTo(tvRatedNumber.start)
            }
        )

        val productCountries = movieDetail.productionCountries?.let {
            Json.decodeFromString<ArrayList<ProductCountries>>(it)
        } ?: emptyList()

        val country = productCountries[0].iso_3166_1 ?: "US"
        Text(
            text = country, fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .constrainAs(tvCountry) {
                    top.linkTo(tvMovieDate.bottom, 5.dp)
                    start.linkTo(tvMovieDate.start)
                }
                .drawBehind {
                    drawRoundRect(
                        Color(0xFF007bd9),
                        cornerRadius = CornerRadius(6.dp.toPx())
                    )
                }
                .padding(start = 6.dp, top = 4.dp, end = 6.dp, bottom = 4.dp)
        )

        val genre = movieDetail.genres.let {
            Json.decodeFromString<ArrayList<Genre>>(it)[0].name
        } ?: "ACTION"

        Text(
            text = genre, fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .constrainAs(tvGenre) {
                    top.linkTo(tvCountry.top)
                    start.linkTo(tvCountry.end, 10.dp)
                }
                .drawBehind {
                    drawRoundRect(
                        Color(0xFF007bd9),
                        cornerRadius = CornerRadius(6.dp.toPx())
                    )
                }
                .padding(start = 6.dp, top = 4.dp, end = 6.dp, bottom = 4.dp)
        )

        Text(
            text = movieDetail.title ?: "",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(tvMovieName) {
                top.linkTo(imgMovieThumb.bottom, 20.dp)
                start.linkTo(imgMovieThumb.start)
            }
        )

        Text(
            text = movieDetail.overview ?: "",
            fontSize = 14.sp,
            modifier = Modifier
                .constrainAs(tvMovieDesc) {
                    top.linkTo(tvMovieName.bottom, 5.dp)
                    start.linkTo(imgMovieThumb.start)
                }
                .padding(end = 20.dp),
            maxLines = 5,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@DevicePreviews
@Composable
fun PreviewMovieDetail(
    @PreviewParameter(MovieDetailPreviewParameterProvider::class) movieDetailFakeDataPreviewUI: MovieDetailFakeDataPreviewUI
) {
    MovieDetailBody(movieDetail = movieDetailFakeDataPreviewUI.listDbMovieDetailFakeDataPreviewUI[0]) {}
}
