package navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.tmdb.feature.home.HomeScreen
import com.tmdp.feature.detail.MovieDetailScreen

/**
 * Created by Tam Nguyen on 23/07/2023.
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RootNavigation(navController: NavHostController) {

    AnimatedNavHost(navController = navController, startDestination = NavigationScreen.HomeScreenRoute.route) {

        composable(NavigationScreen.HomeScreenRoute.route) {
            HomeScreen(navToMovieDetail = { movieId -> navController.navigate(NavigationScreen.MovieDetailRoute.openMovieDetail(movieId)) })
        }

        composable(NavigationScreen.MovieDetailRoute.route) { navBackStackEntry ->
            val movieId = navBackStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: 0
            MovieDetailScreen(movieId = movieId) {
                navController.popBackStack()
            }
        }
    }
}
