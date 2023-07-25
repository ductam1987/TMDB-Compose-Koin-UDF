package com.tmdb.core.network.intercepter

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.internal.platform.Platform
import okio.Buffer
import java.nio.charset.Charset
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

/**
 * Created by Tam Nguyen on 12/07/2023.
 */
class LoggerInterceptor private constructor() : Interceptor {

    private val utf8 = Charset.forName("UTF-8")
    private var _charLimit = 2000
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val connection = chain.connection()
        val protocol = connection?.protocol() ?: Protocol.HTTP_1_1

        val requestBuilder = request.newBuilder().build()
        val bufferRequest = Buffer()
        requestBuilder.body?.writeTo(bufferRequest)

        var requestStartMessage = "--> ${request.method} ${request.url} $protocol"

        request.body?.let {
            requestStartMessage = String.format(
                "%s\nContent-Header:: \n%sContent-Type:: %s\nContent-Length:: %s\nContent-Body:: %s",
                requestStartMessage,
                request.headers.toString(),
                it.contentType(),
                it.contentLength(),
                bufferRequest.readUtf8(),
            )
        } ?: let {
            requestStartMessage = String.format(
                "%s\nContent-Header:: \n%s",
                requestStartMessage,
                request.headers.toString(),
            )
        }

        Log.i("INFO", requestStartMessage)

        val startNs = System.nanoTime()
        val response = chain.proceed(request)
        val tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs)

        val responseBody = response.body
        responseBody?.let {
            val contentLength = responseBody.contentLength()
            val bodySize = if (contentLength != -1L) "$contentLength-byte" else "unknown-length"

            Log.i("INFO", response.headers.toString())
            Log.i(
                "INFO",
                "<-- ${response.code} ${response.message} ${response.request.url} (${tookMs}ms, $bodySize)",
            )

            val source = responseBody.source()
            source.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
            val buffer = source.buffer

            var charset: Charset = utf8
            responseBody.contentType()?.let {
                try {
                    charset = it.charset(utf8)!!
                } catch (e: Exception) {
                    Log.i("INFO", "")
                    Log.i("INFO", "Couldn't decode the response body; charset is likely malformed.")
                    Log.i("INFO", "${e.message}")
                    Log.i("INFO", "<-- END HTTP")
                }
            }

            if (contentLength != 0L) {
                Log.i("INFO", "")
                val message = buffer.clone().readString(charset)
                if (message.length < _charLimit) {
                    Log.i("INFO", message)
                } else {
                    val sections = message.length / _charLimit
                    for (i in 0..sections) {
                        val max = _charLimit * (i + 1)
                        if (max >= message.length) {
                            Log.i("INFO", message.substring(_charLimit * i))
                        } else {
                            Log.i("INFO", message.substring(_charLimit * i, max))
                        }
                    }
                }
            }
            Log.i("INFO", "<-- END HTTP (${buffer.size}-byte body)")
        }

        return response
    }

    class Builder {
        private val headers: HashMap<String, String> = HashMap()
        private val httpUrl: HashMap<String, String> = HashMap()
        private var isLogHackEnable = false
        private var isDebug: Boolean = false
        private var type = Platform.INFO
        private var requestTag: String = ""
        private var responseTag: String = ""
        var level = Level.BASIC

        // internal var logger: Logger? = null
        //     private set
        private var executor: Executor? = null
        internal var isMockEnabled: Boolean = false
        internal var sleepMs: Long = 0
        // internal var listener: BufferListener? = null

        internal fun getLevel(): Level {
            return level
        }

        /**
         * @param level set log level
         * @return Builder
         * @see Level
         */
        fun setLevel(level: Level): Builder {
            this.level = level
            return this
        }

        internal fun getTag(isRequest: Boolean): String {
            return if (isRequest) {
                if (requestTag.isEmpty()) TAG else requestTag
            } else {
                if (responseTag.isEmpty()) TAG else responseTag
            }
        }

        /**
         * @param name Filed
         * @param value Value
         * @return Builder
         * Add a field with the specified value
         */
        fun addHeader(name: String, value: String): Builder {
            headers[name] = value
            return this
        }

        /**
         * @param name Filed
         * @param value Value
         * @return Builder
         * Add a field with the specified value
         */
        fun addQueryParam(name: String, value: String): Builder {
            httpUrl[name] = value
            return this
        }

        /**
         * Set request and response each log tag
         *
         * @param tag general log tag
         * @return Builder
         */
        fun tag(tag: String): Builder {
            TAG = tag
            return this
        }

        /**
         * Set request log tag
         *
         * @param tag request log tag
         * @return Builder
         */
        fun request(tag: String): Builder {
            this.requestTag = tag
            return this
        }

        /**
         * Set response log tag
         *
         * @param tag response log tag
         * @return Builder
         */
        fun response(tag: String): Builder {
            this.responseTag = tag
            return this
        }

        /**
         * @param isDebug set can sending log output
         * @return Builder
         */
        fun loggable(isDebug: Boolean): Builder {
            this.isDebug = isDebug
            return this
        }

        /**
         * @param type set sending log output com.netacom.com.netacom.base.chat.type
         * @return Builder
         * @see Platform
         */
        fun log(type: Int): Builder {
            this.type = type
            return this
        }

        /**
         * @param logger manuel logging interface
         * @return Builder
         * @see Logger
         */
        // fun logger(logger: Logger): Builder {
        //     this.logger = logger
        //     return this
        // }

        /**
         * @param executor manual executor for printing
         * @return Builder
         * @see Logger
         */
        fun executor(executor: Executor): Builder {
            this.executor = executor
            return this
        }

        fun build(): LoggerInterceptor {
            return LoggerInterceptor()
        }

        companion object {
            private var TAG = "TMDB Service"
        }
    }
}
