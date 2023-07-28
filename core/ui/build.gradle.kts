@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("tmdbcompose.android.library.compose")
    id("tmdbcompose.android.library")
}

android {
    namespace = "com.tmdb.core.ui"
}

dependencies {

    implementation(project(":core:model"))
    implementation(project(":core:repos"))
    implementation(project(":core:network"))

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.runtime.livedata)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.metrics)
    api(libs.androidx.tracing.ktx)
    api(libs.viewmodel.ktx)

    api(libs.lifecycle.runtime.compose)

    implementation(libs.androidx.browser)
    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.kotlinx.datetime)
    implementation(libs.sandwich.network)

    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.customview)
    implementation(libs.androidx.customview.poolingcontainer)

    implementation(libs.androidx.compose.constraintlayout)
}
