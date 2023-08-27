@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("tmdbcompose.android.library")
    id("tmdbcompose.android.library.compose")
}

android {
    namespace = "com.tmdb.core.testing"
}

dependencies {

    api(libs.androidx.compose.ui.test)
    api(libs.androidx.test.core)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.rules)
    api(libs.androidx.test.runner)
    api(libs.junit4)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)
    debugApi(libs.androidx.compose.ui.test.manifest)
}
