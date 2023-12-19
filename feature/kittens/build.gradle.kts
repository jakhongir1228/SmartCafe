plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization")
}

android {
    namespace = "uz.smartcafe.feature.kittens"
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

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.20.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    //mvi
    implementation(project(":feature:mvi"))
}
