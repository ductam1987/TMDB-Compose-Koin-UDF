package com.tmdb.core.model.fakeData

import com.tmdb.core.model.network.AuthorDetail
import com.tmdb.core.model.network.ReviewDetails

/**
 * Created by Tam Nguyen on 24/07/2023.
 */

val authorDetailFakeData = AuthorDetail(
    name = "Chris Sawin",
    username = "ChrisSawin",
    avatar_path = "/https://secure.gravatar.com/avatar/bf3b87ecb40599290d764e6d73c86319.jpg",
)

val reviewDetailsFakeData = ReviewDetails(
    author = "The Movie Mob",
    content = "The Flash uses the vast catalog of DC history to create an experience that celebrates the past films, " +
        "highlights the good of the current DC movies, and opens the door for the future.**\\r\\n\\r\\n" +
        "The Flash reaches a high point on the roller coaster that is the inconsistent and directionless DC film universe. " +
        "The story, the action, the laughs, and the cameos make The Flash a worthy cinematic debut for the Scarlet Speedster. " +
        "The movie tone finds its influences more in the Marvel and Joss Whedon realm than the DC and Christopher Nolan universe, ",
    id = "648a09e86f8d95013c755685",
    url = "https://www.themoviedb.org/review/648a09e86f8d95013c755685",
    authorDetail = authorDetailFakeData,
    updatedAt = "2023-06-09T23:22:37.321Z"
)
