plugins {
    id("tmdbcompose.android.library")
}

android {
    namespace = "com.tmdb.core.data"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:network"))

    implementation(libs.sandwich.network)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
