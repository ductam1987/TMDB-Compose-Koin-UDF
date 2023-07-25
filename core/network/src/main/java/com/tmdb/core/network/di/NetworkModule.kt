package com.tmdb.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import com.tmdb.core.network.EndPoint
import com.tmdb.core.network.RestTMDBService
import com.tmdb.core.network.intercepter.HostApiInterceptor
import com.tmdb.core.network.intercepter.Level
import com.tmdb.core.network.intercepter.LoggerInterceptor
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.ConnectionSpec
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * Created by Tam Nguyen on 17/07/2023.
 */

private const val OKHttpApi = "OKHttpApi"
private const val RetrofitApi = "RetrofitApi"

@OptIn(ExperimentalSerializationApi::class)
val networkModule = module {

    single {
        Json {
            ignoreUnknownKeys = true
            encodeDefaults = true
            explicitNulls = true
            prettyPrint = true
            isLenient = true
            coerceInputValues = true
        }
    }

    single {
        with(LoggerInterceptor.Builder()) {
            setLevel(Level.BODY)
            log(Platform.INFO)
            request("App_request")
            response("App_response")
            build()
        }
    }

    singleOf(::HostApiInterceptor)

    single(named(OKHttpApi)) {
        with(OkHttpClient.Builder()) {
            addInterceptor(get() as HostApiInterceptor)
            addInterceptor(get() as LoggerInterceptor)
            connectTimeout(15, TimeUnit.SECONDS)
            readTimeout(15, TimeUnit.SECONDS)
            clearText()
            build()
        }
    }

    single(named(RetrofitApi)) {
        with(Retrofit.Builder()) {
            baseUrl(EndPoint.URL_API)
            client(get(named(OKHttpApi)) as OkHttpClient)
            addConverterFactory((get() as Json).asConverterFactory("application/json".toMediaType()))
            addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            build()
        }
    }

    single { get<Retrofit>(named(RetrofitApi)).create(RestTMDBService::class.java) }
}

fun OkHttpClient.Builder.clearText(): OkHttpClient.Builder {
    val spec = ConnectionSpec.Builder(ConnectionSpec.COMPATIBLE_TLS).allEnabledCipherSuites().build()
    connectionSpecs(listOf(spec, ConnectionSpec.CLEARTEXT))
    return this
}
