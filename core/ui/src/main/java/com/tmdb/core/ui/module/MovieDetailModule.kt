package com.tmdb.core.ui.module

import com.skydoves.sandwich.ApiResponse
import com.tmdb.core.model.db.DbMovieDetail
import com.tmdb.core.model.mapper.MovieDetailMapper
import com.tmdb.core.model.network.MovieDetail
import com.tmdb.core.network.CoroutineDispatchers
import com.tmdb.core.network.config.MovieDetailConfig
import com.tmdb.core.repos.LocalDbRepository
import com.tmdb.core.repos.MovieDetailRepository
import com.tmdb.core.ui.network.NetworkBoundRepository
import com.tmdb.core.ui.network.ResultData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Tam Nguyen on 29/07/2023.
 */
object MovieDetailModule {
    suspend fun provideMovieDetailModule(
        movieDetailConfig: MovieDetailConfig,
        localDbRepository: LocalDbRepository,
        movieDetailRepository: MovieDetailRepository,
        movieDetailMapper: MovieDetailMapper,
        coroutineDispatchers: CoroutineDispatchers
    ): Flow<ResultData<DbMovieDetail?>> {

        return object : NetworkBoundRepository<DbMovieDetail?, MovieDetail?>() {
            override suspend fun saveRemoteData(response: MovieDetail?) {
                response?.let { movieDetail ->
                    localDbRepository.saveMovieDetail(movieDetailMapper.mapToEntity(movieDetail))
                }
            }

            override suspend fun fetchFromLocal(): Flow<DbMovieDetail?> = flow {
                emit(localDbRepository.getMovieDetail(movieDetailConfig.movieId.toLong()))
            }

            override suspend fun fetchFromRemote(): ApiResponse<MovieDetail?> {
                return movieDetailRepository.getMovieDetail(movieDetailConfig)
            }
        }.asFlow().flowOn(coroutineDispatchers.io)
    }
}
