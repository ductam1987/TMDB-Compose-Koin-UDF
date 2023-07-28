package com.tmdb.core.model.fakeData

import com.tmdb.core.model.db.DbMovie
import com.tmdb.core.model.network.Movie

/**
 * Created by Tam Nguyen on 20/07/2023.
 */
val movieFakeData1 = DbMovie(
    adult = false,
    backdropPath = "/AaABt75ZzfMGrscUR2seabz4PEX.jpg",
    id = 297762,
    title = "Wonder Woman",
    originalLanguage = "en",
    originalTitle = "Wonder Woman",
    overview = "An Amazon princess comes to the world of Man in the grips of the First World War to confront the forces of evil and bring an end to human conflict.",
    posterPath = "/imekS7f1OuHyUP2LAiTEM0zBzUz.jpg",
    mediaType = "movie",
    genreIds = arrayListOf("28,12,14"),
    popularity = 73.592,
    releaseDate = "2017-05-30",
    video = false,
    voteAverage = 7.238,
    voteCount = 18764
)

val movieFakeData2 = DbMovie(
    adult = false,
    backdropPath = "/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg",
    id = 284053,
    title = "Thor: Ragnarok",
    originalLanguage = "en",
    originalTitle = "Thor: Ragnarok",
    overview = "Thor is imprisoned on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the destruction of his home-world and the end of Asgardian civilization, at the hands of a powerful new threat, the ruthless Hela.",
    posterPath = "/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg",
    mediaType = "movie",
    genreIds = arrayListOf("28,12,878"),
    popularity = 79.436,
    releaseDate = "2017-10-02",
    video = false,
    voteAverage = 7.595,
    voteCount = 19306
)

val movieFakeData3 = DbMovie(
    adult = false,
    backdropPath = "/fn4n6uOYcB6Uh89nbNPoU2w80RV.jpg",
    id = 315635,
    title = "Spider-Man: Homecoming",
    originalLanguage = "en",
    originalTitle = "Spider-Man: Homecoming",
    overview = "Following the events of Captain America: Civil War, Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in Queens, New York City, with fighting crime as his superhero alter ego Spider-Man as a new threat, the Vulture, emerges.",
    posterPath = "/c24sv2weTHPsmDa7jEMN0m2P3RT.jpg",
    mediaType = "movie",
    genreIds = arrayListOf("28,12,878,18"),
    popularity = 111.169,
    releaseDate = "2017-07-05",
    video = false,
    voteAverage = 7.346,
    voteCount = 20226
)

val movieFakeData4 = Movie(
    adult = false,
    backdrop_path = "/6YwkGolwdOMNpbTOmLjoehlVWs5.jpg",
    id = 99861,
    title = "Avengers: Age of Ultron",
    original_language = "en",
    original_title = "Avengers: Age of Ultron",
    overview = "When Tony Stark tries to jumpstart a dormant peacekeeping program, things go awry and Earth’s Mightiest Heroes are put to the ultimate test as the fate of the planet hangs in the balance. As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.",
    poster_path = "/4ssDuvEDkSArWEdyBl2X5EHvYKU.jpg",
    media_type = "movie",
    genre_ids = arrayListOf("28,12,878"),
    popularity = 84.246,
    release_date = "2015-04-22",
    video = false,
    vote_average = 7.279,
    vote_count = 21500
)

val movieFakeData5 = Movie(
    adult = false,
    backdrop_path = "/iYdgEUE2W2aJkgqfSjf1x3gFfuV.jpg",
    id = 363088,
    title = "Ant-Man and the Wasp",
    original_language = "en",
    original_title = "Ant-Man and the Wasp",
    overview = "Just when his time under house arrest is about to end, Scott Lang once again puts his freedom at risk to help Hope van Dyne and Dr. Hank Pym dive into the quantum realm and try to accomplish, against time and any chance of success, a very dangerous rescue mission.",
    poster_path = "/6KFB9nRiC8gSrV5J5Wjf7zRIJYm.jpg",
    media_type = "movie",
    genre_ids = arrayListOf("28,12,878"),
    popularity = 42.033,
    release_date = "2018-07-04",
    video = false,
    vote_average = 6.953,
    vote_count = 12343
)

val listMovieFakeData = listOf(movieFakeData4, movieFakeData5)

val listDbMovieFakeData = listOf(movieFakeData1, movieFakeData2, movieFakeData3)
