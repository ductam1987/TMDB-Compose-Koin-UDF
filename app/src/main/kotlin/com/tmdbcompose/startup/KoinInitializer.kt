package com.tmdbcompose.startup

import android.content.Context
import androidx.startup.Initializer
import com.tmdbcompose.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Tam Nguyen on 17/07/2023.
 */
class KoinInitializer : Initializer<KoinApplication> {

    override fun create(context: Context): KoinApplication {
        return startKoin {
            androidLogger(Level.ERROR)
            androidContext(androidContext = context)
            androidFileProperties()
            workManagerFactory()
            modules(allModules)
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(LoggerInitializer::class.java)
}
