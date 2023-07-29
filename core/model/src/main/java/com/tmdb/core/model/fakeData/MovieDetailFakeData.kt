package com.tmdb.core.model.fakeData

import com.tmdb.core.model.db.DbMovieDetail
import com.tmdb.core.model.network.Genre
import com.tmdb.core.model.network.MovieDetail
import com.tmdb.core.model.network.ProductCountries
import com.tmdb.core.model.network.SpokenLanguages

/**
 * Created by Tam Nguyen on 24/07/2023.
 */
val movieDetailFakeData = MovieDetail(
    adult = false,
    backdrop_path = "/yF1eOkaYvwiORauRCPWznV9xVvi.jpg",
    budget = 190000000,
    genres = arrayListOf(
        Genre(id = 28, name = "Action"),
        Genre(id = 12, name = "Adventure"),
        Genre(id = 878, name = "Science Fiction")
    ),
    homepage = "https://www.dc.com/theflash",
    id = 298618,
    imdb_id = "tt0439572",
    original_language = "en",
    original_title = "The Flash",
    overview = "When his attempt to save his family inadvertently alters the future, Barry Allen becomes trapped in a reality in " +
        "which General Zod has returned and there are no Super Heroes to turn to. In order to save the world that he is in and " +
        "return to the future that he knows, Barry's only hope is to race for his life. But will making the ultimate sacrifice " +
        "be enough to reset the universe?",
    poster_path = "/rktDFPbfHfUbArZ6OOOKsXcv0Bm.jpg",
    release_date = "2023-06-13",
    revenue = 267481043,
    runtime = 144,
    spoken_languages = arrayListOf(
        SpokenLanguages(
            iso_639_1 = "en",
            name = "English"
        ),
        SpokenLanguages(
            iso_639_1 = "es",
            name = "Español"
        ),
        SpokenLanguages(
            iso_639_1 = "ru",
            name = "Pусский"
        )
    ),
    status = "Released",
    tagline = "Worlds collide.",
    title = "The Flash",
    video = false,
    vote_average = 6.9263543543543534,
    vote_count = 1379,
    production_countries = arrayListOf(
        ProductCountries(
            iso_3166_1 = "US",
            name = "United States of America"
        )
    )
)

val dbMovieDetailFakeData = DbMovieDetail(
    adult = false,
    backdropPath = "/yF1eOkaYvwiORauRCPWznV9xVvi.jpg",
    budget = 190000000,
    genres = "",
    // genres = arrayListOf(
    //     Genre(id = 28, name = "Action"),
    //     Genre(id = 12, name = "Adventure"),
    //     Genre(id = 878, name = "Science Fiction")
    // ),
    homepage = "https://www.dc.com/theflash",
    id = 298618,
    imdbId = "tt0439572",
    originalLanguage = "en",
    originalTitle = "The Flash",
    overview = "When his attempt to save his family inadvertently alters the future, Barry Allen becomes trapped in a reality in " +
        "which General Zod has returned and there are no Super Heroes to turn to. In order to save the world that he is in and " +
        "return to the future that he knows, Barry's only hope is to race for his life. But will making the ultimate sacrifice " +
        "be enough to reset the universe?",
    posterPath = "/rktDFPbfHfUbArZ6OOOKsXcv0Bm.jpg",
    releaseDate = "2023-06-13",
    revenue = 267481043,
    runtime = 144,
    spokenLanguages = "",
    // arrayListOf(
    //     SpokenLanguages(
    //         iso_639_1 = "en",
    //         name = "English"
    //     ),
    //     SpokenLanguages(
    //         iso_639_1 = "es",
    //         name = "Español"
    //     ),
    //     SpokenLanguages(
    //         iso_639_1 = "ru",
    //         name = "Pусский"
    //     )
    // ),
    status = "Released",
    tagline = "Worlds collide.",
    title = "The Flash",
    video = false,
    voteAverage = 6.9263543543543534,
    voteCount = 1379,
    productionCountries = ""
    // arrayListOf(
    //     ProductCountries(
    //         iso_3166_1 = "US",
    //         name = "United States of America"
    //     )
    // )
)
