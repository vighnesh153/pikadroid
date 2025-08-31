plugins {
    id("pikadroid-library-plugin")
}

android {
    namespace = "dev.pikadroid.compose.unstyled"
}

dependencies {

    testImplementation(libs.bundles.test.essentials)
    androidTestImplementation(libs.bundles.test.essentials.android)
}