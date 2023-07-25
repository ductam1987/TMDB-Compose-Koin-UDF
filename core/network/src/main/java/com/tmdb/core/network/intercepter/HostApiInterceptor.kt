package com.tmdb.core.network.intercepter

import com.tmdb.core.network.EndPoint
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by Tam Nguyen on 17/07/2023.
 */
class HostApiInterceptor : Interceptor {
    private var token: String? = null

    fun setToken(newToken: String?) {
        token = newToken
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var newRequest = EndPoint.URL_API.toHttpUrlOrNull()?.let {
            val newUrl = chain.request().url.newBuilder()
                .host(it.toUrl().toURI().host)
                .port(it.port)
                .build()
            val headers = chain.request().headers.newBuilder()
            return@let chain.request().newBuilder()
                .headers(headers.build())
                .url(newUrl)
                .build()
        }
        if (newRequest == null) newRequest = chain.request()
        return chain.proceed(newRequest)
    }
}
