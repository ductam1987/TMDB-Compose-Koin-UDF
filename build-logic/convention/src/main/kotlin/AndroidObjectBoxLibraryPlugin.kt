import com.android.build.api.dsl.ApplicationExtension
import com.tmdpcompose.build.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Created by Tam Nguyen on 27/07/2023.
 */
class AndroidObjectBoxLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.objectbox")
        }
    }
}