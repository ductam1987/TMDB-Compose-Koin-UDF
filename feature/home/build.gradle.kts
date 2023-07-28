plugins {
    id("tmdbcompose.android.feature")
    id("tmdbcompose.android.library.compose")
    // id("tmdbcompose.android.library")
}

android {
    namespace = "com.tmdb.feature.recommend"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompact)
    implementation(libs.orhanobut.logger)
}
