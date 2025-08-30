plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "dev.pikadroid.compose.unstyled"
    compileSdk = PikadroidGradleConfig.COMPILE_SDK

    defaultConfig {
        minSdk = PikadroidGradleConfig.MIN_SDK

        testInstrumentationRunner = PikadroidGradleConfig.INSTRUMENTATION_TEST_RUNNER
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
    compileOptions {
        sourceCompatibility = PikadroidGradleConfig.SourceCompatibility
        targetCompatibility = PikadroidGradleConfig.TargetCompatibility
    }
    kotlinOptions {
        jvmTarget = PikadroidGradleConfig.JVM_TARGET
    }
}

dependencies {
}