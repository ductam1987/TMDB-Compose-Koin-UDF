package com.tmdbcompose

import android.app.Application
import com.tmdb.core.repos.LocalDbRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by Tam Nguyen on 27/07/2023.
 */
class TMDBApplication : Application(), KoinComponent {

    private val localDbRepository by inject<LocalDbRepository>()
    override fun onCreate() {
        super.onCreate()
        localDbRepository.init(applicationContext)
    }
}