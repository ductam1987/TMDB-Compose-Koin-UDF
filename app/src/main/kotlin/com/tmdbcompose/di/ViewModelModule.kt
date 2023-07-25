package com.tmdbcompose.di

import com.tmdb.feature.home.RecommendViewModel
import com.tmdp.feature.detail.MovieDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Created by Tam Nguyen on 18/07/2023.
 */
val viewModelModule = module {
    viewModelOf(::RecommendViewModel)
    viewModelOf(::MovieDetailViewModel)
}
