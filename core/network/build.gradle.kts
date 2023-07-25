@file:Suppress("UnstableApiUsage")

plugins {
    id("tmdbcompose.android.library")
}

android {
    namespace = "com.tmdb.core.network"
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.orhanobut.logger)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.sandwich.network)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
