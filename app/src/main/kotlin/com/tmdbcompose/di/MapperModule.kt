package com.tmdbcompose.di

import org.koin.dsl.module
import com.tmdb.core.model.mapper.RecommendationMapper
import com.tmdb.core.model.mapper.MoviesMapper
import org.koin.core.module.dsl.factoryOf

/**
 * Created by Tam Nguyen on 27/07/2023.
 */
val mapperModule = module {
    factoryOf(::RecommendationMapper)
    factoryOf(::MoviesMapper)
}