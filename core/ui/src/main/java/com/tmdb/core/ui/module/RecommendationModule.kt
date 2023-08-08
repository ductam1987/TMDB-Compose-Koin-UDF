package com.tmdb.core.ui.module

import com.skydoves.sandwich.ApiResponse
import com.tmdb.core.model.db.SubDbMovie
import com.tmdb.core.model.mapper.MoviesMapper
import com.tmdb.core.model.mapper.RecommendationMapper
import com.tmdb.core.model.network.Movies
import com.tmdb.core.network.CoroutineDispatchers
import com.tmdb.core.network.config.RecommendConfigDb
import com.tmdb.core.network.config.RecommendConfigNetwork
import com.tmdb.core.repos.LocalDbRepository
import com.tmdb.core.repos.TMDBRepository
import com.tmdb.core.ui.network.NetworkBoundRepository
import com.tmdb.core.ui.network.ResultData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Tam Nguyen on 27/07/2023.
 */
object RecommendationModule {

    suspend fun provideRecommendationModule(
        recommendConfig: RecommendConfigNetwork,
        localDbRepository: LocalDbRepository,
        tmdbRepository: TMDBRepository,
        recommendationMapper: RecommendationMapper,
        moviesMapper: MoviesMapper,
        coroutineDispatchers: CoroutineDispatchers
    ): Flow<ResultData<SubDbMovie>> {

        return object : NetworkBoundRepository<SubDbMovie, Movies?>() {
            override suspend fun saveRemoteData(response: Movies?) {
                response?.results?.let { listMovie ->
                    localDbRepository.saveMovies(moviesMapper.mapToEntity(response))
                    localDbRepository.saveListMovie(recommendationMapper.mapToListEntity(listMovie))
                }
            }

            override suspend fun fetchFromLocal(): Flow<SubDbMovie> = flow {
                val recommendConfigDb = RecommendConfigDb(
                    offset = (
                        if (recommendConfig.page == 1) 0L
                        else (recommendConfig.page.minus(1)).times(20L)
                        ),
                    limit = 20
                )
                emit(
                    SubDbMovie(
                        totalResults = localDbRepository.getMovies()?.totalResult,
                        listDbMovies = localDbRepository.getListMovie(recommendConfigDb)
                    )
                )
            }

            override suspend fun fetchFromRemote(): ApiResponse<Movies?> {
                return tmdbRepository.getMoviesRecommendations(recommendConfig)
            }
        }.asFlow().flowOn(coroutineDispatchers.io)
    }
}
