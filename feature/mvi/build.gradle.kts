plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "uz.smartcafe.feature.mvi"
    compileSdk = 34

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("com.badoo.reaktive:reaktive:2.0.1")
    implementation("com.badoo.reaktive:reaktive-annotations:2.0.1")
    implementation("com.badoo.reaktive:coroutines-interop:2.0.1")
    implementation("com.badoo.reaktive:rxjava2-interop:2.0.1")
    implementation("com.badoo.reaktive:rxjava3-interop:2.0.1")
}