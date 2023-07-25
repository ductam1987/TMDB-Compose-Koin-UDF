package com.tmdb.core.ui

import androidx.compose.foundation.shape.RoundedCornerShape

val Int?.shapesRounded: RoundedCornerShape get() = RoundedCornerShape(this ?: 0)
