import org.gradle.api.JavaVersion

object PikadroidGradleConfig {
    const val COMPILE_SDK = 35
    const val MIN_SDK = 24
    const val INSTRUMENTATION_TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    val SourceCompatibility = JavaVersion.VERSION_11
    val TargetCompatibility = JavaVersion.VERSION_11
    const val JVM_TARGET = "11"
}