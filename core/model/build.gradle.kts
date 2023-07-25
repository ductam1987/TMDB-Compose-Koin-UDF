plugins {
    id("tmdbcompose.android.library")
    id("tmdbcompose.android.library.compose")
    id("kotlinx-serialization")
}

android {
    namespace = "com.tmdb.core.model"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    api(libs.androidx.compose.runtime)
}
