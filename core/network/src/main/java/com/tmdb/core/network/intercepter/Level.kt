package com.tmdb.core.network.intercepter

/**
 * Created by Tam Nguyen on 12/07/2023.
 */
enum class Level {
    /**
     * No logs.
     */
    NONE,

    /**
     *
     * Example:
     * <pre>`- URL
     * - Method
     * - Headers
     * - Body
     `</pre> *
     */
    BASIC,

    /**
     *
     * Example:
     * <pre>`- URL
     * - Method
     * - Headers
     `</pre> *
     */
    HEADERS,

    /**
     *
     * Example:
     * <pre>`- URL
     * - Method
     * - Body
     `</pre> *
     */
    BODY,

    /*CustomLog*/
    CloudHMS,
}
