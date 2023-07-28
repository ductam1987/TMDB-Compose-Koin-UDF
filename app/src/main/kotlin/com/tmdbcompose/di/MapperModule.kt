package com.tmdbcompose.di

import com.tmdb.core.model.mapper.MoviesMapper
import com.tmdb.core.model.mapper.RecommendationMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

/**
 * Created by Tam Nguyen on 27/07/2023.
 */
val mapperModule = module {
    factoryOf(::RecommendationMapper)
    factoryOf(::MoviesMapper)
}
