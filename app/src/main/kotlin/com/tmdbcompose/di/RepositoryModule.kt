package com.tmdbcompose.di

import com.tmdb.core.repos.MovieDetailRepository
import com.tmdb.core.repos.MovieDetailRepositoryImpl
import com.tmdb.core.repos.TMDBRepository
import com.tmdb.core.repos.TMDBRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Created by Tam Nguyen on 21/07/2023.
 */

val repositoryModule = module {
    singleOf(::TMDBRepositoryImpl) { bind<TMDBRepository>() }
    singleOf(::MovieDetailRepositoryImpl) { bind<MovieDetailRepository>() }
}
