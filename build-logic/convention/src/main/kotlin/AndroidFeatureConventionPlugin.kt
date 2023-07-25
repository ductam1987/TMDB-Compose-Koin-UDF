import com.android.build.gradle.LibraryExtension
import com.tmdpcompose.build.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

/**
 * Created by Tam Nguyen on 20/07/2023.
 */

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("tmdbcompose.android.library")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner =
                        "com.google.samples.apps.nowinandroid.core.testing.NiaTestRunner"
                }
            }

            dependencies {
                add("testImplementation", kotlin("test"))

                add("implementation", project(":core:model"))
                add("implementation", project(":core:network"))
                add("implementation", project(":core:repos"))
                add("implementation", project(":core:ui"))

                add("implementation", libs.findLibrary("coil.kt").get())
                add("implementation", libs.findLibrary("coil.kt.compose").get())

                add("implementation", libs.findLibrary("lifecycle.runtime.compose").get())
                add("implementation", libs.findLibrary("viewmodel.compose").get())

                add("implementation", libs.findLibrary("koin.compose").get())
                add("implementation", libs.findLibrary("koin.android").get())
                add("implementation", libs.findLibrary("koin.worker").get())

                add("implementation", libs.findLibrary("sandwich.network").get())

                add("implementation", libs.findLibrary("androidx.compose.ui.tooling.preview").get())
                add("implementation", libs.findLibrary("androidx-compose-ui-tooling").get())
                add("implementation", libs.findLibrary("androidx-customview").get())
                add("implementation", libs.findLibrary("androidx-customview-poolingcontainer").get())

                add("implementation", libs.findLibrary("androidx-compose-constraintlayout").get())
                add("implementation", libs.findLibrary("compose-ratingbar").get())
            }
        }
    }
}
