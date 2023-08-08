package com.tmdb.core.network.config

/**
 * Created by Tam Nguyen on 08/08/2023.
 */
data class RecommendConfigDb(
    var offset: Long,
    var limit: Long = 20
)
