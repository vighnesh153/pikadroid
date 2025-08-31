plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("pikadroid-library-plugin") {
            id = "pikadroid-library-plugin"
            implementationClass = "PikadroidLibraryPlugin"
        }
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    val kotlinVersion = libs.versions.kotlin.get()
    val agpVersion = libs.versions.agp.get()

    //noinspection UseTomlInstead
    implementation("com.android.tools.build:gradle:$agpVersion")
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation(kotlin("android-extensions", kotlinVersion))
}
