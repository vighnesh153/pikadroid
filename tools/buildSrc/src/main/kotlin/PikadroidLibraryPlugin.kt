import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion

class PikadroidLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply("kotlin-android")
        project.plugins.apply("android-library")

        project.extensions.getByType(JavaPluginExtension::class.java).apply {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(17))
            }
        }

        project.extensions.getByType(LibraryExtension::class.java).apply {
            compileSdkVersion(35)

            defaultConfig {
                minSdk = 24

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                release {
                    isMinifyEnabled = false

                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            testOptions {
                // Gradle managed devices are not yet stable. Running tests on them fails because of
                // some random issues like failed to pull system image, not enough memory available, etc.
                managedDevices {
                    val pikadroidTestDevices = listOf(
                        localDevices.create("pixel_9_pro_xl_api_36") {
                            device = "Pixel 9 Pro XL"
                            sdkVersion = 36
                            systemImageSource = "google"
                        },
                        localDevices.create("pixel_7a_api_31") {
                            device = "Pixel 7a"
                            sdkVersion = 31
                            systemImageSource = "google"
                        },
                        localDevices.create("small_phone_api_24") {
                            device = "Small Phone"
                            sdkVersion = 24
                            systemImageSource = "google"
                        }
                    )

                    groups.create("pikadroidTestDevices") {
                        targetDevices.addAll(pikadroidTestDevices)
                    }
                }
            }
        }
    }
}