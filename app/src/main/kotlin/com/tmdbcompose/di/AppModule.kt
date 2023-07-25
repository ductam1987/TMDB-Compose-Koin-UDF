package com.tmdbcompose.di

import com.tmdb.core.network.CoroutineDispatchers
import com.tmdb.core.network.DefaultCoroutineDispatchers
import com.tmdb.core.network.di.networkModule
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by Tam Nguyen on 17/07/2023.
 */

val appModule = module {
    singleOf(::DefaultCoroutineDispatchers) bind CoroutineDispatchers::class
}

val allModules = module {
    includes(
        appModule,
        networkModule,
        viewModelModule,
        repositoryModule
    )
}
