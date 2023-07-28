package com.tmdbcompose.di

import com.tmdb.core.repos.LocalDbRepository
import com.tmdb.core.repos.LocalDbRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by Tam Nguyen on 27/07/2023.
 */
val databaseModule = module {
    singleOf(::LocalDbRepositoryImpl) bind LocalDbRepository::class
}
