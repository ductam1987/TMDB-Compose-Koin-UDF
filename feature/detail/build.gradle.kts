plugins {
    id("tmdbcompose.android.feature")
    id("tmdbcompose.android.library.compose")
    // id("tmdbcompose.android.library")
}

android {
    namespace = "com.tmdb.feature.detail"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompact)
}
