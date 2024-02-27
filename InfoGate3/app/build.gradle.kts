plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.infogate3"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.infogate3"
        minSdk = 29
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("com.intuit.ssp:ssp-android:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
   // implementation("androidx.compose.foundation:foundation-android:1.6.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.google.android.gms:play-services-vision:20.1.3")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.2")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("com.itextpdf:itextg:5.5.10")
   // implementation("androidx.core:core:1.12.0")

    implementation ("com.airbnb.android:lottie:6.1.0")

//    Responsive Size
    implementation("com.intuit.sdp:sdp-android:1.1.0")


}