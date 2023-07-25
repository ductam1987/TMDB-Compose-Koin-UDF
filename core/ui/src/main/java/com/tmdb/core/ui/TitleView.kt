package com.tmdb.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Tam Nguyen on 23/07/2023.
 */

@Composable
fun TitleView(stringResourceId: Int, imgResourceId: Int) {
    Row(
        modifier = Modifier
            .height(30.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = stringResourceId),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = painterResource(id = imgResourceId),
            contentDescription = "Arrow Right"
        )
    }
}
