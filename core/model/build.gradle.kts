plugins {
    id("tmdbcompose.android.library")
    id("tmdbcompose.android.library.compose")
    id("kotlinx-serialization")
    id("tmdbcompose.objectbox")
}

android {
    namespace = "com.tmdb.core.model"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    api(libs.androidx.compose.runtime)
}
