plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.gboard"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.gboard"
        minSdk = 31
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // ✅ Retrofit for API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // ✅ Gson Converter for Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // ✅ Gson (optional but safe)
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


    // ✅ Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
