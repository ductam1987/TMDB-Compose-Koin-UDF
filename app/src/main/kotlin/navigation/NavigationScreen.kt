package navigation

/**
 * Created by Tam Nguyen on 23/07/2023.
 */
sealed class NavigationScreen(val route: String) {

    object HomeScreenRoute : NavigationScreen("homeScreen")
    object MovieDetailRoute : NavigationScreen("movieDetail/{movieId}") {
        fun openMovieDetail(movieId: Int) = "movieDetail/$movieId"
    }
}
