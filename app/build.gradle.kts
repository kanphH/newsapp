plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrainsKotlinSerialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.gms.google.services)
}



android {
    namespace = "com.loc.newsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.loc.newsapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    android {
        namespace = "kan.kpo.newsapp" // ✅ ต้องกำหนดตรงนี้แทน
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.firestore.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Room
    implementation(libs.bundles.room)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)
    implementation(libs.ksp.gradlePlugin)

    // Coil
    implementation(libs.coil.compose)

    // Ktor
    implementation(libs.bundles.ktor)

    // Koin
    implementation(libs.bundles.koin)

    // Extended Icons
    implementation(libs.androidx.material.icons.extended)

    // Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    implementation("androidx.core:core-splashscreen:1.0.1")

    implementation("androidx.compose.ui:ui-text-google-fonts")

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth.ktx)

    // ใช้เวอร์ชันเสถียรล่าสุด
    implementation (libs.androidx.credentials)

    // สำหรับรองรับ Play Services บนอุปกรณ์ที่ใช้ Android 13 หรือต่ำกว่า (ไม่บังคับ)
    implementation ("androidx.credentials:credentials-play-services-auth:1.2.2")


// ✅ สำหรับ ViewModel โดยเฉพาะ




}
